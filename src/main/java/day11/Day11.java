package day11;

import utils.Position;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\day11\\input.txt");
    public static List<String> expandedFromTopToBottomList = new ArrayList<>();
    public static List<String> completelyExpandedList = new ArrayList<>();
    public static List<Position> positionsOfChar = new ArrayList<>();
    public static void main(String[] args) {

        expandedFromTopToBottomList = expandRows(inputArrayList);
        List<String> transposedList = transposeList(expandedFromTopToBottomList);
        completelyExpandedList = expandRows(transposedList);

        for (String value : completelyExpandedList){
            System.out.println(value);
        }

        positionsOfChar = getPositionsOfChar(completelyExpandedList, '#');

        for (Position position : positionsOfChar){
            System.out.println(position);
        }

    }

    public static List<Position> getPositionsOfChar(List<String> inputList, char charToFind){
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            int row = 0;
            do {
                int index = inputList.get(i).indexOf(charToFind, row);
                if(index == -1){
                    break;
                }
                positions.add(new Position(i,index));
                row = index+1;
            } while (row < inputList.get(0).length());
        }
        return positions;
    }


    public static List<String> expandRows(List<String> inputList){
        List<String> expandedList = new ArrayList<>();

        for (String row : inputList){
            if (row.contains("#")){
                expandedList.add(row);
            } else {
                expandedList.add(row);
                expandedList.add(row);
            }
        }
        return expandedList;
    }

    public static List<String> transposeList(List<String> inputList){
        List<String> expandedList = new ArrayList<>();

        for (int i = 0; i < inputList.get(0).length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < inputList.size(); j++) {
                stringBuilder.append(inputList.get(j).charAt(i));
            }
            expandedList.add(stringBuilder.toString());
        }
        return expandedList;
    }
}