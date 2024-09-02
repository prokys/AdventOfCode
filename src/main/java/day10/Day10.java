package day10;

import utils.Position;
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
    public static List<PositionOfChar> knownPositions = new ArrayList<>();
    public static List<Position> insidePositions = new ArrayList<>();

    public static int finalNumber = 0;
    public static int finalNumber1 = 0;
    public static void main(String[] args) {
        partOne();
        partTwo();
    }
    public static void partOne(){
        positionOfChar = findWhereToMoveFromStart(startingPosition, inputArrayList);
        knownPositions.add(positionOfChar);
        do {
            positionOfChar = getPositionOfCharOfNext(positionOfChar);
            if(!knownPositions.contains(positionOfChar)){
                knownPositions.add(positionOfChar);
            }
            finalNumber++;
        }while (startingPosition !=positionOfChar);
        System.out.println(finalNumber/2);
    }

    public static void partTwo(){
        for (PositionOfChar position : knownPositions){
            addInsideCoordinatesToList(position);
        }

        System.out.println(insidePositions.size());
//        System.out.println(finalNumber1);
    }

    private static void addInsideCoordinatesToList(PositionOfChar position) {

        char charToCompare = getCharAtPosition(position,inputArrayList);
        PositionOfChar positionToCompare = new PositionOfChar(position);

        if (positionToCompare.getMovedFrom() != null){

            switch (positionToCompare.getMovedFrom()){
                case "up" -> {

                    if (charToCompare == 'L'){
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()+1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setRowPosition(positionToCompare.getRowPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getRowPosition() >= 0 && positionToCompare.getRowPosition() <= inputArrayList.get(0).length()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    } else if (charToCompare == '|') {
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setRowPosition(positionToCompare.getRowPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getRowPosition() >= 0 && positionToCompare.getRowPosition() <= inputArrayList.get(0).length()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }
//                    System.out.println("up");
                }
                case "down" -> {

                    if (charToCompare == '7'){
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            }else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setRowPosition(positionToCompare.getRowPosition()+1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getRowPosition() >= 0 && positionToCompare.getRowPosition() <= inputArrayList.get(0).length()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }
//                    System.out.println("down");
                }
                case "left" -> {

                    if (charToCompare == 'J'){
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()+1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setRowPosition(positionToCompare.getRowPosition()+1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getRowPosition() >= 0 && positionToCompare.getRowPosition() <= inputArrayList.get(0).length()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }else if (charToCompare == '-'){
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()+1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }
//                    System.out.println("left");
                }
                case "right" -> {

                    if (charToCompare == 'F'){
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                        for (int i = 1; i < 100; i++) {
                            positionToCompare.setRowPosition(positionToCompare.getRowPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getRowPosition() >= 0 && positionToCompare.getRowPosition() <= inputArrayList.get(0).length()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }else if (charToCompare == '-'){
                        for (int i = 1; i < 10; i++) {
                            positionToCompare.setColumnPosition(positionToCompare.getColumnPosition()-1);
                            if (knownPositions.contains(positionToCompare)){
                                break;
                            } else if (positionToCompare.getColumnPosition() >= 0 && positionToCompare.getColumnPosition() <= inputArrayList.size()-1){
                                Position positionToAdd = new Position(positionToCompare);
                                if (!insidePositions.contains(positionToAdd)){
                                    insidePositions.add(positionToAdd);
                                }
                            }
                        }
                    }
//                    System.out.println("right");
                }
            }
        }
    }


    public static PositionOfChar getPositionOfCharOfNext(PositionOfChar inputPosition){
        PositionOfChar newPosition = new PositionOfChar();
        char charAt = getCharAtPosition(inputPosition, inputArrayList);
        switch (charAt){
            case '|' -> {
                if (lastPosition.getColumnPosition() < inputPosition.getColumnPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("up");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("down");
                }
            }
            case 'L' -> {
                if (lastPosition.getColumnPosition() < inputPosition.getColumnPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                    inputPosition.setMovedFrom("up");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("right");
                }
            }
            case '-' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                    inputPosition.setMovedFrom("left");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                    inputPosition.setMovedFrom("right");
                }
            }
            case 'J' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()-1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("left");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                    inputPosition.setMovedFrom("up");
                }
            }
            case '7' -> {
                if (lastPosition.getRowPosition() < inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("left");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()-1);
                    inputPosition.setMovedFrom("down");
                }
            }
            case 'F' -> {
                if (lastPosition.getRowPosition() > inputPosition.getRowPosition()){
                    newPosition.setColumnPosition(inputPosition.getColumnPosition()+1);
                    newPosition.setRowPosition(inputPosition.getRowPosition());
                    inputPosition.setMovedFrom("right");
                }else {
                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                    newPosition.setRowPosition(inputPosition.getRowPosition()+1);
                    inputPosition.setMovedFrom("down");
                }
            }
            case 'S' -> newPosition = startingPosition;

        }
        lastPosition = inputPosition;
        return newPosition;
    }

    public static PositionOfChar findWhereToMoveFromStart(PositionOfChar inputPosition, List<String> listToCheck){
        List<Position> listOfPossiblePositions = new ArrayList<>();
            listOfPossiblePositions.add(new Position(inputPosition.getColumnPosition()-1,inputPosition.getRowPosition()));
            listOfPossiblePositions.add(new Position(inputPosition.getColumnPosition(),inputPosition.getRowPosition()+1));
            listOfPossiblePositions.add(new Position(inputPosition.getColumnPosition()+1,inputPosition.getRowPosition()));
            listOfPossiblePositions.add(new Position(inputPosition.getColumnPosition(),inputPosition.getRowPosition()-1));

        PositionOfChar newPosition = new PositionOfChar();

                    for (Position position : listOfPossiblePositions){
                        if (0 < position.getColumnPosition() ||
                                inputArrayList.size() > position.getColumnPosition() ||
                                0 < position.getRowPosition() ||
                                inputArrayList.get(0).length() < position.getRowPosition()){
                            if (upOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(0),listToCheck)) && !listOfPossiblePositions.get(0).equals(lastPosition))  {
                                    newPosition.setColumnPosition(inputPosition.getColumnPosition() - 1);
                                    newPosition.setRowPosition(inputPosition.getRowPosition());
                                    newPosition.setMovedFrom("down");
                                    break;
                            } else if (rightOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(1),listToCheck)) && !listOfPossiblePositions.get(2).equals(lastPosition)) {
                                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                                    newPosition.setRowPosition(inputPosition.getRowPosition() + 1);
                                    newPosition.setMovedFrom("left");
                                    break;
                            } else if (downOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(2),listToCheck)) && !listOfPossiblePositions.get(1).equals(lastPosition)){
                                    newPosition.setColumnPosition(inputPosition.getColumnPosition() + 1);
                                    newPosition.setRowPosition(inputPosition.getRowPosition());
                                    newPosition.setMovedFrom("up");
                                    break;
                            } else if (leftOfChar.contains(getCharAtPosition(listOfPossiblePositions.get(3),listToCheck)) && !listOfPossiblePositions.get(3).equals(lastPosition)) {
                                    newPosition.setColumnPosition(inputPosition.getColumnPosition());
                                    newPosition.setRowPosition(inputPosition.getRowPosition() - 1);
                                    newPosition.setMovedFrom("right");
                                    break;
                            } else {
                                newPosition = startingPosition;
                                break;
                        }
                    }

                    }
        lastPosition = inputPosition;
                return newPosition;
            }
    public static char getCharAtPosition(Position positionToCheck, List<String> listToCheck){
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
