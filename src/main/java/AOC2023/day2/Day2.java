package AOC2023.day2;

import utils.Utils;

import java.util.ArrayList;

public class Day2 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day2\\input.txt");
    public static ArrayList<Integer> gamePositionsList = new ArrayList<Integer>();
    public static int partOneNumber =0;
    public static int partTwoNumber =0;

    public static void main(String args[]){
        String[] inputArray = inputArrayList.toArray(new String[0]);
//        Utils.printArray(inputArray);
        getGamePositions(inputArray);
        Integer[] positionsArray = gamePositionsList.toArray(new Integer[0]);
//        Utils.printArray(inputArray);
        checkColors(inputArray, positionsArray);
        countSumOfMinimumCubesSetPower(inputArray, positionsArray);
        System.out.println(partOneNumber);
        System.out.println(partTwoNumber);


    }

    public static void getGamePositions(String array[]){
        for (int i = 0; i<array.length; i++){
            if (array[i].contains("Game")){
                gamePositionsList.add(i);
            }
        }
        gamePositionsList.add(array.length);
    }
    public static void checkColors(String array[], Integer positionArray[]){
        for (int i = 1; i<positionArray.length; i++){
            Boolean red = true;
            Boolean blue = true;
            Boolean green = true;
            for (int y=positionArray[i-1]; y<positionArray[i]; y++ ){
                if (array[y].startsWith("red")){
                    if (Integer.parseInt(array[y-1])>12){
                        red = false;
                    }
                } else if (array[y].startsWith("blue")) {
                    if (Integer.parseInt(array[y - 1]) > 14) {
                        blue = false;
                    }
                }else if (array[y].startsWith("green")) {
                    if (Integer.parseInt(array[y - 1]) > 13) {
                        green = false;
                    }
                }
            }

            if(red == true && blue == true && green == true){
                partOneNumber = partOneNumber + (Integer.parseInt(array[(positionArray[i-1])+1].replaceAll(":","")));
            }
        }
    }
    public static void countSumOfMinimumCubesSetPower(String array[], Integer positionArray[]){
        for (int i = 1; i<positionArray.length; i++){
            int red = 0;
            int blue = 0;
            int green = 0;
            for (int y=positionArray[i-1]; y<positionArray[i]; y++ ){
                if (array[y].startsWith("red")){
                    if (Integer.parseInt(array[y-1])> red){
                        red = Integer.parseInt(array[y - 1]);
                    }
                } else if (array[y].startsWith("blue")) {
                    if (Integer.parseInt(array[y - 1]) > blue) {
                        blue = Integer.parseInt(array[y - 1]);
                    }
                }else if (array[y].startsWith("green")) {
                    if (Integer.parseInt(array[y - 1]) > green) {
                        green = Integer.parseInt(array[y - 1]);
                    }
                }
            }
                partTwoNumber = partTwoNumber + (red*blue*green);
        }
    }
}
