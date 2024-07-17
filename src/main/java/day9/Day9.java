package day9;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day9 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\day9\\input.txt");
    public static List<List<Integer>> splitArrayList = new ArrayList<>();

    public static int finalNumber = 0;
    public static void main(String[] args) {
        splitArrayList = splitListBySequencesAndMakeItInteger(inputArrayList);
        for (List<Integer> integers : splitArrayList) {
            finalNumber = finalNumber + findNextNumber(integers);
        }
        System.out.println(finalNumber);

    }

    public static int findNextNumber(List<Integer> list) {
        int nextNumber = 0;
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
        for (List<Integer> integers : tempList) {
            nextNumber = nextNumber + integers.get(integers.size() - 1);
        }
        return nextNumber;
    }

    public static List<List<Integer>> splitListBySequencesAndMakeItInteger(List<String> listToTransfer){
            List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < (listToTransfer.size()/21); i++){
            List<Integer> tempValueList = new ArrayList<>();
            for (int y = 0; y<21; y++){
                tempValueList.add(Integer.parseInt(listToTransfer.get(y+(i*21))));
            }
            newList.add(i, tempValueList);
        }

        return newList;
    }
}
