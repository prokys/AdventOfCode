package AOC2025.day3;

import java.util.List;

import static java.lang.Math.pow;

public class Day3 {

    static int position = 0;

    public static int partOne(List<String> inputList){

        int finalNumber = 0;
        for (String s : inputList){
            finalNumber = finalNumber + getHighestTwo(s);
        }
        return finalNumber;
    }

    public static long partTwo(List<String> inputList){

        long finalNumber = 0;
        for (String s : inputList){
            finalNumber = finalNumber + getHighestTwelve(s);
        }
        return finalNumber;
    }

    private static long getHighestTwelve(String s) {
        long num = 0;
        for (int i = 0; i < 12; i++) {
            num = num + getHighestWithRange(s, i);
        }
        position = 0;
        return num;
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

    private static long getHighestWithRange(String input, int range) {

        int highest = 0;

        for (int i = position; i < input.length()-11 + range; i++) {
            int number = Character.getNumericValue(input.charAt(i));
            if (number > highest) {
                highest = number;
                position = i+1;
            }
        }
        return (long) (highest * pow(10, 11-range));
    }
}
