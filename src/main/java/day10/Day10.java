package day10;

import utils.PositionOfChar;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\day10\\input.txt");
    public static PositionOfChar startingPosition = getPositionOfChar('S', inputArrayList);
    public static PositionOfChar lastPosition = new PositionOfChar();
    public static PositionOfChar positionOfChar = new PositionOfChar();
    public static List<Character> upOfChar = Arrays.asList('|', '7', 'F');
    public static List<Character> downOfChar = Arrays.asList('|', 'L', 'J');
    public static List<Character> leftOfChar = Arrays.asList('-', 'L', 'F');
    public static List<Character> rightOfChar = Arrays.asList('-', '7', 'J');

    public static int finalNumber = 0;

    public static void main(String[] args) {
        partOne();
    }
    public static void partOne(){
        positionOfChar = findWhereToMoveFromStart(startingPosition, inputArrayList);
        do {
            positionOfChar = getPositionOfCharOfNext(positionOfChar);
            finalNumber++;
        }while (startingPosition !=positionOfChar);
        System.out.println(finalNumber/2);
    }
    public static PositionOfChar getPositionOfCharOfNext(PositionOfChar inputPosition){
        PositionOfChar newPosition = new PositionOfChar();
        char charAt = getCharAtPosition(inputPosition, inputArrayList);
        switch (charAt){
            case '|' -> {
                if (lastPosition.getColumnPosition() < inputPosition.getColumnPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }
            }
            case 'L' -> {
                if (lastPosition.getColumnPosition() < inputPosition.getColumnPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }
            }
            case '-' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                }
            }
            case 'J' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                }
            }
            case '7' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                }
            }
            case 'F' -> {
                if (lastPosition.getRowPosition() > inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                }
            }
            case 'S' -> newPosition = startingPosition;

        }
        lastPosition = inputPosition;
        return newPosition;
    }

    public static PositionOfChar findWhereToMoveFromStart(PositionOfChar inputPosition, List<String> listToCheck){
        List<PositionOfChar> listOfPossiblePositions = new ArrayList<>();
        listOfPossiblePositions.add(new PositionOfChar(inputPosition.getColumnPosition()-1,inputPosition.getRowPosition()));
        listOfPossiblePositions.add(new PositionOfChar(inputPosition.getColumnPosition()+1,inputPosition.getRowPosition()));
        listOfPossiblePositions.add(new PositionOfChar(inputPosition.getColumnPosition(),inputPosition.getRowPosition()+1));
        listOfPossiblePositions.add(new PositionOfChar(inputPosition.getColumnPosition(),inputPosition.getRowPosition()-1));
        PositionOfChar newPosition = new PositionOfChar();

                    if ((upOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(0),listToCheck)) && !listOfPossiblePositions.get(0).equals(lastPosition)))  {
                        newPosition.setColumnPosition(inputPosition.getColumnPosition() - 1);
                        newPosition.setRowPosition(inputPosition.getRowPosition());
                    } else if (rightOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(2),listToCheck)) && !listOfPossiblePositions.get(2).equals(lastPosition)) {
                        newPosition.setColumnPosition(inputPosition.getColumnPosition());
                        newPosition.setRowPosition(inputPosition.getRowPosition() + 1);
                    } else if (downOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(1),listToCheck)) && !listOfPossiblePositions.get(1).equals(lastPosition)) {
                        newPosition.setColumnPosition(inputPosition.getColumnPosition() + 1);
                        newPosition.setRowPosition(inputPosition.getRowPosition());
                    } else if (leftOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(3),listToCheck)) && !listOfPossiblePositions.get(3).equals(lastPosition)){
                        newPosition.setColumnPosition(inputPosition.getColumnPosition());
                        newPosition.setRowPosition(inputPosition.getRowPosition() - 1);
                    } else {
                        newPosition = startingPosition;
                    }
        lastPosition = inputPosition;
                return newPosition;
            }
    public static char getCharAtPosition(PositionOfChar positionToCheck, List<String> listToCheck){
        return listToCheck.get(positionToCheck.getColumnPosition()).charAt(positionToCheck.getRowPosition());
    }
    public static PositionOfChar getPositionOfChar(char charToFind, List<String> list) {
        PositionOfChar positionOfChar = new PositionOfChar();
        int positionInRow;
        for (int positionInColumn = 0; positionInColumn < list.size(); positionInColumn++) {
            positionInRow = list.get(positionInColumn).indexOf(charToFind);
            if (positionInRow != -1) {
                positionOfChar.setRowPosition(positionInRow);
                positionOfChar.setColumnPosition(positionInColumn);
                break;
            }
        }
        return positionOfChar;
    }
}
