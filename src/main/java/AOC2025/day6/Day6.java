package AOC2025.day6;

import java.util.ArrayList;
import java.util.List;

public class Day6 {

    public static long partOne(List<List<String>> input){

        long finalNumber = 0;

        for (int i = 0; i < input.get(0).size(); i++) {
            long number = 0;
            for (int j = 0; j < input.size()-1; j++) {
                if (input.get(input.size()-1).get(i).equals("+")){
                    number = number + Integer.parseInt(input.get(j).get(i));
                }else {
                    if (number == 0){
                        number = Integer.parseInt(input.get(j).get(i));
                    }else {
                        number = number * Integer.parseInt(input.get(j).get(i));
                    }
                }

            }
            finalNumber = finalNumber+number;
        }


        return finalNumber;
    }

    public static long partTwo(List<String> input){

        long finalNumber = 0;

        List<List<String>> finalInputList = getInputWithSpaces(input);

        for (int i = 0; i < finalInputList.get(0).size(); i++) {
            long number = 0;
            List<String> tempList = new ArrayList<>();

            for (int j = 0; j < finalInputList.size()-1; j++) {
                tempList.add(finalInputList.get(j).get(i));
            }

            for (int j = 0; j < tempList.get(0).length(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : tempList) {
                    stringBuilder.append(s.charAt(j));
                }

                String numberToCount = stringBuilder.toString().trim();

                if (finalInputList.get(finalInputList.size()-1).get(i).trim().equals("+")){
                    number = number + Integer.parseInt(numberToCount);
                }else {
                    if (number == 0){
                        number = Integer.parseInt(numberToCount);
                    }else {
                        number = number * Integer.parseInt(numberToCount);
                    }
                }
            }
            finalNumber = finalNumber+number;
        }

        return finalNumber;
    }


    public static List<List<String>> getInputWithSpaces(List<String> input){

        List<Integer> columnSpaces = getSpaces(input);

        List<List<String>> finalList = new ArrayList<>();

        for (String s : input){
            List<String> line = new ArrayList<>();
            for (int i = 0; i < columnSpaces.size()-1; i++){
                line.add(s.substring(columnSpaces.get(i)+1, columnSpaces.get(i+1)));
                if (i == columnSpaces.size()-2){
                    line.add(s.substring(columnSpaces.get(i+1)+1));
                }
            }
            finalList.add(line);
        }
        return finalList;
    }

    private static List<Integer> getSpaces(List<String> input) {
        List<Integer> allSpaces = new ArrayList<>();

        for (String s : input){
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' '){
                    allSpaces.add(i);
                }
            }
        }

        List<Integer> columnSpaces = new ArrayList<>();
        columnSpaces.add(-1);

        for (Integer i : allSpaces){
            boolean all = true;
            for (String s : input) {
                if (s.charAt(i) != ' ') {
                    all = false;
                    break;
                }
            }
            if (all) {
                if (!columnSpaces.contains(i)) columnSpaces.add(i);
            }

        }
        return columnSpaces;
    }
}
