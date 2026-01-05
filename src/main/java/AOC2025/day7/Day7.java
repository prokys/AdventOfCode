package AOC2025.day7;

import utils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day7 {

    static HashMap<Position,Long> nodeOptions;

    public static int partOne(List<String> input){

        return Integer.parseInt(getModifiedList(input, false).get(0));
    }

    public static long partTwo(List<String> input){

        nodeOptions = new HashMap<>();
        List<String> modifiedList = getModifiedList(input, true);

        for (int i = modifiedList.size()-1; i >-1 ; i--) {
            StringBuilder line = new StringBuilder(modifiedList.get(i));
            for (int j = 0; j < line.length(); j++) {
                char currentChar = modifiedList.get(i).charAt(j);
                if (currentChar == '^'){
                    long value = countOptions(modifiedList, i, j);
                    nodeOptions.put(new Position(j,i),value);
                }
            }
        }

        Position position = new Position();
        position.setRowPosition(2);
        for (int i = 0; i < modifiedList.get(1).length(); i++) {
            if (modifiedList.get(2).charAt(i) == '^'){
                position.setColumnPosition(i);
            }
        }
        return nodeOptions.get(position);
    }

    private static long countOptions(List<String> input, int row, int column) {

        long options = 0;

        for (int i = row; i < input.size(); i++) {
            StringBuilder line = new StringBuilder(input.get(i));
            if (line.charAt(column-1) == '^'){
                Position position = new Position(column-1, i);
                options = options + nodeOptions.get(position);
                i = input.size();
            } else if (i == input.size()-1) {
                options = options + 1;
            }
        }
        for (int i = row; i < input.size(); i++) {
            StringBuilder line = new StringBuilder(input.get(i));
            if (line.charAt(column+1) == '^'){
                Position position = new Position(column+1, i);
                options = options + nodeOptions.get(position);
                i = input.size();
            } else if (i == input.size()-1) {
                options = options + 1;
            }
        }

        return options;
    }

    private static List<String> getModifiedList(List<String> input, Boolean modifier){

        int finalNumber = 0;
        List<String> inputToModify = new ArrayList<>(input);
        for (int i = 1; i < inputToModify.size(); i++) {
            StringBuilder line = new StringBuilder(inputToModify.get(i));
            for (int j = 0; j < line.length(); j++) {
                char currentChar = inputToModify.get(i).charAt(j);
                char previousChar = inputToModify.get(i-1).charAt(j);

                if (currentChar == '.' && (previousChar == '|' || previousChar == 'S')){
                    line.setCharAt(j,'|');
                } else if (currentChar == '^' && previousChar == '|'  ) {
                    if (inputToModify.get(i).charAt(j-1) == '.'){
                        line.setCharAt(j-1,'|');
                    }
                    if (inputToModify.get(i).charAt(j+1) == '.') {
                        line.setCharAt(j+1,'|');
                    }
                    finalNumber++;
                }
            }
            inputToModify.set(i, line.toString());
        }
        if (modifier){
            return inputToModify;
        }else return new ArrayList<>(List.of(Integer.toString(finalNumber)));

    }
}
