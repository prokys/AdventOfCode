package AOC2023.day11;

import utils.Position;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day11\\input.txt");
    public static List<String> expandedFromTopToBottomList = new ArrayList<>();
    public static List<String> completelyExpandedList = new ArrayList<>();
    public static List<Position> positionsOfChar = new ArrayList<>();
    public static List<Integer> columnExpandsList = new ArrayList<>();
    public static List<Integer> rowExpandsList = new ArrayList<>();

    public static long finalNumber = 0;
    public static long finalNumberTwo = 0;
    public static void main(String[] args) {
        rowExpandsList = getExpandPoints(inputArrayList);
        columnExpandsList = getExpandPoints(transposeList(inputArrayList));

        positionsOfChar = getPositionsOfChar(inputArrayList, '#');

        partOne();

        partTwo();
    }

    public static void partTwo(){
        finalNumberTwo = computeCharDistances(positionsOfChar, 999999, columnExpandsList, rowExpandsList);

        System.out.println(finalNumberTwo);
    }

    public static List<Integer> getExpandPoints(List<String> inputList){
        List<Integer> expandPoints = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++){
            if (!inputList.get(i).contains("#")){
                expandPoints.add(i);
            }
        }
        return expandPoints;
    }

    public static void partOne(){
        finalNumber = computeCharDistances(positionsOfChar, 1, columnExpandsList, rowExpandsList);

        System.out.println(finalNumber);
    }

    public static long computeCharDistances(List<Position> positions, long expandMultiplier, List<Integer> rowExpands, List<Integer> columnExpands){
        long number = 0;
        for (int i = 0; i < positions.size(); i++) {
            for (int j = i+1; j < positions.size(); j++) {
                int rowPositionOne = positions.get(i).getRowPosition();
                int rowPositionTwo = positions.get(j).getRowPosition();

                int columnPositionOne = positions.get(i).getColumnPosition();
                int columnPositionTwo = positions.get(j).getColumnPosition();

                number = number + Math.abs(rowPositionOne-rowPositionTwo) + Math.abs(columnPositionOne - columnPositionTwo);

                for (int row : rowExpands){
                    if (rowPositionOne > row && row > rowPositionTwo){
                        number = number+expandMultiplier;
                    } else if (rowPositionTwo > row && row > rowPositionOne) {
                        number = number+expandMultiplier;
                    }
                }
                for (int column : columnExpands){
                    if (columnPositionOne > column && column > columnPositionTwo){
                        number = number+expandMultiplier;
                    } else if (columnPositionTwo > column && column > columnPositionOne) {
                        number = number+expandMultiplier;
                    }
                }

            }

        }
        return number;
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
