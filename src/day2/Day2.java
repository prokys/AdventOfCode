package day2;

import utils.Utils;

import java.util.ArrayList;

public class Day2 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day2\\input.txt");
    public static ArrayList<Integer> gamePositionsList = new ArrayList<Integer>();
    public static int number=0;

    public static void main(String args[]){
        String[] inputArray = inputArrayList.toArray(new String[0]);
//        Utils.printArray(inputArray);
        getGamePositions(inputArray);
        Integer[] positionsArray = gamePositionsList.toArray(new Integer[0]);
//        Utils.printArray(inputArray);
        checkColors(inputArray, positionsArray);
        System.out.println(number);


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
                number = number + (Integer.parseInt(array[(positionArray[i-1])+1].replaceAll(":","")));
            }
        }
    }
}
