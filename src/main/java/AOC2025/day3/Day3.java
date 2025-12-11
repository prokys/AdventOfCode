package AOC2025.day3;

import java.util.List;

public class Day3 {


    public static int partOne(List<String> inputList){

        int finalNumber = 0;
        for (String s : inputList){
            finalNumber = finalNumber + getHighestTwo(s);
        }
        return finalNumber;
    }

    private static int getHighestTwo(String input) {

        int highest = 0;
        int second = 0;

        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            if (number > highest){
                if (i == input.length()-1){
                    return highest*10+number;
                }else {
                    highest = number;
                    second = 0;
                }
            } else if (number > second) {
                second = number;
            }
        }
        return highest*10+second;
    }
}
