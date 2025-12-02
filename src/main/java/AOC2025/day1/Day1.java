package AOC2025.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.readFileAndStoreValues;

public class Day1 {

    static int startCode = 50;
    static List<String> inputList = readFileAndStoreValues("src/main/java/AOC2025/day1/input.txt");
//    static List<String> inputList = Arrays.asList("L50", "L100");

    public static void main(String[] args) {
        partOne();
    }

    public static void partOne(){
        int code = startCode;
        int finalNumber = 0;

        for (String input : inputList){
            code = countCode(input, code);
            code = fixOverFlow(code);
            if (code == 0) finalNumber++;
        }

        System.out.println(finalNumber);
    }


    public static int countCode(String input, int code){

        char direction = input.charAt(0);
        int clicks = Integer.parseInt(input.substring(1));

        switch (direction){
            case 'L':{
                code = code - clicks;
                break;
            }
            case 'R':{
                code = code + clicks;
                break;
            }
        }
        return code;
    }

    public static int fixOverFlow(int input){
        do {
        if (input < 0) input = input+100;
        else if (input > 99) input = input-100;
        }while (input < 0 || input > 99);
        return input;
    }



}
