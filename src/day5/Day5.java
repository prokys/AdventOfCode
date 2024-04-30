package day5;

import utils.Utils;

import java.util.ArrayList;

public class Day5 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day5\\input.txt");
    private static int seed = inputArrayList.indexOf("seeds:");;
    private static int seedToSoil = inputArrayList.indexOf("seed-to-soil");
    private static  int soilToFertilizer= inputArrayList.indexOf("soil-to-fertilizer");
    private static int fertilizerToWater= inputArrayList.indexOf("fertilizer-to-water");
    private static int waterToLight= inputArrayList.indexOf("water-to-light");
    private static int lightToTemperature= inputArrayList.indexOf("light-to-temperature");
    private static int temperatureToHumidity= inputArrayList.indexOf("temperature-to-humidity");
    private static int humidityToLocation= inputArrayList.indexOf("humidity-to-location");

    private static long seedValue;
    private static long finalNumber;

    private static ArrayList<Long> locations = new ArrayList<Long>();

    public static void main(String[] args) {
        partOne();

    }

    private static void partOne(){
        for (int i = seed+1; i<seedToSoil; i++){
            seedValue = Long.parseLong(inputArrayList.get(i));
            getLocation();
        }
        getFinalNumber();
        System.out.println(finalNumber);
    }

    private static void getSeedValue(int from, int to, long seedToCompare){
        for (int i =from+3; i<to; i+=3){
            long base = Long.parseLong(inputArrayList.get(i));
            long range = Long.parseLong(inputArrayList.get(i+1));
            long mapValue = Long.parseLong(inputArrayList.get(i-1));

            if (seedToCompare>=base && seedToCompare<(base+range)){
                seedValue = seedValue-base+mapValue;
                break;
            }
        }
    }
    private static void getLocation(){
        getSeedValue(seedToSoil, soilToFertilizer, seedValue);
        getSeedValue(soilToFertilizer, fertilizerToWater, seedValue);
        getSeedValue(fertilizerToWater, waterToLight, seedValue);
        getSeedValue(waterToLight, lightToTemperature, seedValue);
        getSeedValue(lightToTemperature, temperatureToHumidity, seedValue);
        getSeedValue(temperatureToHumidity, humidityToLocation, seedValue);
        getSeedValue(humidityToLocation, inputArrayList.size(), seedValue);
        locations.add(seedValue);
    }

    public static void getFinalNumber() {
        finalNumber = locations.get(0);
        for (int i = 1; i<locations.size(); i++)

            if (finalNumber>locations.get(i)){
                finalNumber = locations.get(i);
            }

    }
}