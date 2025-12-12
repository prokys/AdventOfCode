package AOC2025.day4;

import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static int partOne(List<String> inputList){

        int finalNumber = 0;

        for (int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < inputList.get(0).length(); j++) {

                char center = inputList.get(i).charAt(j);
                if (center == '@'){
                    if (countRolls(i, j, inputList)){
                        finalNumber++;
                    }
                }

            }
        }
        return finalNumber;
    }

    private static boolean countRolls(int row, int column, List<String> inputList) {
        List<Position> positionsList = getPositions(row, column, inputList.size());
        int numberOfRolls = 0;

        for (Position p : positionsList){
            char charToCompare = inputList.get(p.getColumnPosition()).charAt(p.getRowPosition());
            if ('@' == charToCompare){
                numberOfRolls++;
            }
        }
        System.out.println("Position: "+row+", "+column+" has "+numberOfRolls+" around");
        return numberOfRolls < 4;
    }

    private static List<Position> getPositions(int row, int column, int max){
        List<Position> outputList= new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int newRow = row-1;
            int newColumn = column-1+i;
            if (newRow >= 0 && newColumn >= 0 && newColumn < max){
                outputList.add(new Position(newRow,newColumn));
            }
        }
        for (int i = 0; i < 3; i++) {
            int newRow = row+1;
            int newColumn = column-1+i;
            if (newRow < max && newColumn >= 0 && newColumn < max){
                outputList.add(new Position(newRow,newColumn));
            }
        }
        for (int i = 0; i < 3; i+=2) {
            int newColumn = column-1+i;
            if (newColumn >= 0 && newColumn < max){
                outputList.add(new Position(row,newColumn));
            }
        }
        return outputList;
    }
}
