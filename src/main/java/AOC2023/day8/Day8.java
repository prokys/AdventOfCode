package AOC2023.day8;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day8\\input.txt");
    public static List<String> node = new ArrayList<>();
    public static List<String> leftPath = new ArrayList<>();
    public static List<String> rightPath = new ArrayList<>();

    public static String instructions = inputArrayList.get(0);
    public static String startingPosition = "AAA";
    public static int finalNumber = 0;

    public static List<String> currentPositions = new ArrayList<>();
    public static List<String> finalPositions = new ArrayList<>();
    public static List<Integer> stepsToFindEndPosition = new ArrayList<>();


    public static void main(String[] args) {
        splitInputIntoSeparateLists();
        getCurrentAndFinalPositions();
        partOne();
        partTwo();
    }

    public static void partTwo(){
        for (int i=0; i<finalPositions.size(); i++){
            stepsToFindEndPosition.add(getFinalNumberFromStartingPath(currentPositions.get(i), finalPositions));
        }
        System.out.println(leastCommonMultipleForList(stepsToFindEndPosition));

    }
    public static long greatestCommonDivider(long firstNumber, long secondNumber) {
        while (secondNumber != 0) {
            long divider = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = divider;
        }
        return firstNumber;
    }
    public static long leastCommonMultiple(long firstNumber, long secondNumber) {
        return (firstNumber * secondNumber) / greatestCommonDivider(firstNumber, secondNumber);
    }
    public static long leastCommonMultipleForList(List<Integer> listOfNumbers) {
        long result = listOfNumbers.get(0);
        for (int i = 1; i < listOfNumbers.size(); i++) {
            result = leastCommonMultiple(result, listOfNumbers.get(i));
        }
        return result;
    }

    public static void getCurrentAndFinalPositions(){
        String regexAAtTheEnd = "^[A-Z]{2}A$";
        Pattern patternAAtTheEnd = Pattern.compile(regexAAtTheEnd);

        String regexZAtTheEnd = "^[A-Z]{2}Z$";
        Pattern patternZAtTheEnd = Pattern.compile(regexZAtTheEnd);

        for (String position : node){
            Matcher matcherAAtTheEnd = patternAAtTheEnd.matcher(position);
            Matcher matcherZAtTheEnd = patternZAtTheEnd.matcher(position);
            if (matcherAAtTheEnd.matches()){
                currentPositions.add(position);
            } else if (matcherZAtTheEnd.matches()) {
                finalPositions.add(position);
            }
        }
    }

    public static void partOne() {
        finalNumber = getFinalNumberFromStartingPath(startingPosition, finalPositions);
        System.out.println(finalNumber);

    }

    public static int getFinalNumberFromStartingPath(String startingPath, List<String> endPath){
        int numberOfMoves = 0;
        String currentPosition = startingPath;

        for (int i = 0; i < instructions.length(); i++){
            numberOfMoves++;
            int indexOfNode = node.indexOf(currentPosition);
            if (instructions.charAt(i)== 'L'){
                currentPosition = leftPath.get(indexOfNode);
            }else {
                currentPosition = rightPath.get(indexOfNode);
            }
            if (endPath.contains(currentPosition)){
                break;
            }
            if(i == instructions.length()-1){
                i=-1;
            }
        }
        return numberOfMoves;
    }

    public static void splitInputIntoSeparateLists(){
        for (int i = 1; i<inputArrayList.size(); i+=4){
            node.add(inputArrayList.get(i));
            leftPath.add(inputArrayList.get(i+2).replace('(', ' ').replace(',', ' ').trim());
            rightPath.add(inputArrayList.get(i+3).replace(')', ' ').trim());
        }
    }
}
