package AOC2025.day7;

import java.util.ArrayList;
import java.util.List;

public class Day7 {

    public static int partOne(List<String> input){

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
            System.out.println(line);
            }
        return finalNumber;
    }
}
