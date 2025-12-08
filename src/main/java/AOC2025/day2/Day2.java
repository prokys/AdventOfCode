package AOC2025.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static long partOne(String input){

        long finalNumber = 0;
        List<String> inputList = splitInput(input);

        for (int i = 0; i < inputList.size()-1; i+=2) {
            long num1 = Long.parseLong(inputList.get(i));
            long num2 = Long.parseLong(inputList.get(i+1));

            if (inputList.get(i).length()%2 == 1 && inputList.get(i+1).length()%2 == 1){

            }else {
                for (long j = num1; j <= num2; j++) {
                    if (String.valueOf(j).length()%2 == 1){

                    }else {
                    String string = String.valueOf(j);
                    String part1 = string.substring(0, string.length()/2);
                    String part2 = string.substring(string.length()/2);
                    if (part1.equals(part2)){
                        finalNumber = finalNumber+j;
                    }
                    }
                }
            }
        }

        System.out.println(finalNumber);
        return finalNumber;
    }

    public static List<String> splitInput(String input){
        List<String> inputList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){
                stringBuilder.append(input.charAt(i));
            }else {
                inputList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        return inputList;
    }
}
