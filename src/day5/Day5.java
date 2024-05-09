package day5;

import utils.Utils;

import java.util.ArrayList;

public class Day5 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day5\\input.txt");
    private static int seed = inputArrayList.indexOf("seeds:");
    private static int seedToSoil = inputArrayList.indexOf("seed-to-soil");
    private static  int soilToFertilizer= inputArrayList.indexOf("soil-to-fertilizer");
    private static int fertilizerToWater= inputArrayList.indexOf("fertilizer-to-water");
    private static int waterToLight= inputArrayList.indexOf("water-to-light");
    private static int lightToTemperature= inputArrayList.indexOf("light-to-temperature");
    private static int temperatureToHumidity= inputArrayList.indexOf("temperature-to-humidity");
    private static int humidityToLocation= inputArrayList.indexOf("humidity-to-location");

    private static long finalNumber;

    private static ArrayList<Long> locations = new ArrayList<Long>();

    public static void main(String[] args) {
//        partOne();
        partTwo();

    }

    private static void partOne(){
        for (int i = seed+1; i<seedToSoil; i++){
            locations.add(getLocation(Long.parseLong(inputArrayList.get(i))));
        }
        getFinalNumber();
        System.out.println(finalNumber);
    }

    private static void partTwo(){
        for (int i = seed+1; i<seedToSoil; i+=2){
            long seedValue = Long.parseLong(inputArrayList.get(i));
            long seedRange = Long.parseLong(inputArrayList.get(i+1));

                for (long y = seedValue; y<(seedValue+seedRange); y++){
                    locations.add(getLocation(y));
            }


        }
        getFinalNumber();
        System.out.println(finalNumber);
    }

    private static long getSeedValue(int from, int to, long seedToCompare){
        long seedToLocationValue = seedToCompare;
        for (int i =from+3; i<to; i+=3){
            long base = Long.parseLong(inputArrayList.get(i));
            long range = Long.parseLong(inputArrayList.get(i+1));
            long mapValue = Long.parseLong(inputArrayList.get(i-1));

            if (seedToCompare>=base && seedToCompare<(base+range)){
                seedToLocationValue = seedToLocationValue -base+mapValue;
                break;
            }
        }
        return seedToLocationValue;
    }
    private static long getLocation(long seedToLocationBaseValue){
        long seedToLocationValue = seedToLocationBaseValue;
        seedToLocationValue = getSeedValue(seedToSoil, soilToFertilizer, seedToLocationValue);
        seedToLocationValue = getSeedValue(soilToFertilizer, fertilizerToWater, seedToLocationValue);
        seedToLocationValue = getSeedValue(fertilizerToWater, waterToLight, seedToLocationValue);
        seedToLocationValue = getSeedValue(waterToLight, lightToTemperature, seedToLocationValue);
        seedToLocationValue = getSeedValue(lightToTemperature, temperatureToHumidity, seedToLocationValue);
        seedToLocationValue = getSeedValue(temperatureToHumidity, humidityToLocation, seedToLocationValue);
        seedToLocationValue = getSeedValue(humidityToLocation, inputArrayList.size(), seedToLocationValue);
        return seedToLocationValue;
    }

    public static void getFinalNumber() {
        finalNumber = locations.get(0);
        for (int i = 1; i<locations.size(); i++)

            if (finalNumber>locations.get(i)){
                finalNumber = locations.get(i);
            }

    }
}