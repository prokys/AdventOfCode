package AOC2023.day9;

import AOC2023.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day9\\input.txt");
    public static List<List<Integer>> splitArrayList = new ArrayList<>();

    public static int finalNumber = 0;
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne(){
        splitArrayList = splitListBySequencesAndMakeItInteger(inputArrayList, 21);
        for (List<Integer> integers : splitArrayList) {
            finalNumber = finalNumber + sumForNextNumber(getListsOfCalculatedValues(integers));
        }
        System.out.println(finalNumber);
        finalNumber = 0;
    }

    public static void partTwo(){
        for (List<Integer> integers : splitArrayList) {
            Collections.reverse(integers);
            finalNumber = finalNumber + sumForNextNumber(getListsOfCalculatedValues(integers));
        }
        System.out.println(finalNumber);
    }

    public static List<List<Integer>> getListsOfCalculatedValues(List<Integer> list) {
        List<List<Integer>> tempList = new ArrayList<>();
        tempList.add(list);

        while (tempList.get(tempList.size() - 1).size() > 1) {
            List<Integer> previousList = tempList.get(tempList.size() - 1);
            List<Integer> calculatedValuesList = new ArrayList<>();

            for (int y = 0; y < previousList.size() - 1; y++) {
                calculatedValuesList.add(previousList.get(y + 1) - previousList.get(y));
            }
            tempList.add(calculatedValuesList);
        }

        return tempList;
    }
    public static int sumForNextNumber(List<List<Integer>> listOfIntegers){
        int nextNumber = 0;
        for (List<Integer> integers : listOfIntegers) {
            nextNumber = nextNumber + integers.get(integers.size() - 1);
        }
        return nextNumber;
    }

    public static List<List<Integer>> splitListBySequencesAndMakeItInteger(List<String> listToTransfer, int howMayEntriesInOneLine){
            List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < (listToTransfer.size()/howMayEntriesInOneLine); i++){
            List<Integer> tempValueList = new ArrayList<>();
            for (int y = 0; y<howMayEntriesInOneLine; y++){
                tempValueList.add(Integer.parseInt(listToTransfer.get(y+(i*howMayEntriesInOneLine))));
            }
            newList.add(i, tempValueList);
        }

        return newList;
    }
}
