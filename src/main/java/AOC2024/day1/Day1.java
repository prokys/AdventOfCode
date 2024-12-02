package AOC2024.day1;

import AOC2023.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static List<String> inputList = Utils.readFileAndStoreValues("src/main/java/AOC2024/day1/input.txt");

    public static long finalNumber = 0;

    public static void main(String[] args) {

        partOne();

    }

    public static void partOne(){
        List<Integer> firstColumnList = new ArrayList<>();
        List<Integer> secondColumnList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i+=2 ) {
            firstColumnList.add(Integer.parseInt(inputList.get(i)));
            secondColumnList.add(Integer.parseInt(inputList.get(i+1)));
        }

        firstColumnList.sort(null);
        secondColumnList.sort(null);

        for (int i = 0; i < firstColumnList.size(); i++) {
            finalNumber = finalNumber + Math.abs(firstColumnList.get(i) - secondColumnList.get(i));
        }

        System.out.println("finalNumber = " + finalNumber);
        finalNumber = 0;
    }
}
