package AOC2024.day1;

import AOC2023.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day1 {

    public static List<String> inputList = Utils.readFileAndStoreValues("src/main/java/AOC2024/day1/input.txt");
    public static List<Integer> firstColumnList = new ArrayList<>();
    public static List<Integer> secondColumnList = new ArrayList<>();

    public static long finalNumber = 0;

    public static void main(String[] args) {

        for (int i = 0; i < inputList.size(); i+=2 ) {
            firstColumnList.add(Integer.parseInt(inputList.get(i)));
            secondColumnList.add(Integer.parseInt(inputList.get(i+1)));
        }

        firstColumnList.sort(null);
        secondColumnList.sort(null);

        partOne();
        partTwo();

    }

    public static void partOne(){

        for (int i = 0; i < firstColumnList.size(); i++) {
            finalNumber = finalNumber + Math.abs(firstColumnList.get(i) - secondColumnList.get(i));
        }

        System.out.println("finalNumber = " + finalNumber);
        finalNumber = 0;
    }

    public static void partTwo(){

        HashMap<Integer, Integer> numbersInSecondList = new HashMap<>();


        for (Integer value : secondColumnList) {

            if (!numbersInSecondList.containsKey(value)){
                numbersInSecondList.put(value, 1);
            } else {
                numbersInSecondList.replace(value, numbersInSecondList.get(value)+1);
            }
        }

        for (Integer value: firstColumnList) {
            if (numbersInSecondList.containsKey(value)){
                finalNumber = finalNumber + (long) value *numbersInSecondList.get(value);
            }
        }
        System.out.println("finalNumber = " + finalNumber);
        finalNumber = 0;
    }
}
