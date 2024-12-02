package AOC2023.day1;


import java.util.ArrayList;
import java.util.List;

import utils.Utils;


public class Day1 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day1\\input.txt");
    public static List<String> numbersArrayListPartOne = new ArrayList<>();
    public static List<String> twoNumbersArrayListPartOne = new ArrayList<>();
    public static List<String> numbersArrayListPartTwo = new ArrayList<>();
    public static List<String> twoNumbersArrayListPartTwo = new ArrayList<>();
    public static void main(String[] args){
        partOne();
        partTwo();
    }

    public static void partOne(){
        numbersArrayListPartOne = reduceListToNumbers(inputArrayList);
        twoNumbersArrayListPartOne = reduceListToTwoNumbers(numbersArrayListPartOne);
        System.out.println(getFinalNumber(twoNumbersArrayListPartOne));

    }
    public static void partTwo(){
        numbersArrayListPartTwo = reduceListToNumbersWithNumbersAsString(inputArrayList);
        twoNumbersArrayListPartTwo = reduceListToTwoNumbers(numbersArrayListPartTwo);
        System.out.println(getFinalNumber(twoNumbersArrayListPartTwo));
    }

    public static List<String> reduceListToNumbers(List<String> listOfValues){
        List<String> resultsList = new ArrayList<>();
        for (String value : listOfValues){
            var asd = new StringBuilder(value);
            StringBuilder stringBuilder = new StringBuilder();
            for (int y=0; y<asd.length();y++){
                if(Character.isDigit(asd.charAt(y))){
                    stringBuilder.append(asd.charAt(y));
                }
            }
            resultsList.add(stringBuilder.toString());
        }
        return resultsList;
    }

    public static List<String> reduceListToNumbersWithNumbersAsString(List<String> listOfValues){
        List<String> resultsList = new ArrayList<>();
        for (String value : listOfValues){
            var asd = new StringBuilder(value);
            StringBuilder stringBuilder = new StringBuilder();
            for (int y=0; y<asd.length();y++){
                try  {
                    if(Character.isDigit(asd.charAt(y))) {
                        stringBuilder.append(asd.charAt(y));
                    } else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 'o') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'n') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'e') == 0)) {
                        stringBuilder.append("1");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 't') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'w') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'o') == 0)) {
                        stringBuilder.append("2");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 't') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'h') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'r') == 0) &&
                            (Character.compare(asd.charAt(y + 3), 'e') == 0)&&
                            (Character.compare(asd.charAt(y + 4), 'e') == 0))  {
                        stringBuilder.append("3");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 'f') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'o') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'u') == 0) &&
                            (Character.compare(asd.charAt(y + 3), 'r') == 0)){
                        stringBuilder.append("4");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 'f') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'i') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'v') == 0) &&
                            (Character.compare(asd.charAt(y + 3), 'e') == 0)){
                        stringBuilder.append("5");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 's') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'i') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'x') == 0)){
                        stringBuilder.append("6");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 's') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'e') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'v') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'v') == 0) &&
                            (Character.compare(asd.charAt(y + 4), 'n') == 0)){
                        stringBuilder.append("7");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 'e') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'i') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'g') == 0) &&
                            (Character.compare(asd.charAt(y + 3), 'h') == 0) &&
                            (Character.compare(asd.charAt(y + 4), 't') == 0)){
                        stringBuilder.append("8");
                    }else if (Character.isLetter(asd.charAt(y)) &&
                            (Character.compare(asd.charAt(y), 'n') == 0) &&
                            (Character.compare(asd.charAt(y + 1), 'i') == 0) &&
                            (Character.compare(asd.charAt(y + 2), 'n') == 0) &&
                            (Character.compare(asd.charAt(y + 3), 'e') == 0) ){
                        stringBuilder.append("9");
                    }
                }catch (Exception ignore){}
            }
            resultsList.add(stringBuilder.toString());
        }
        return resultsList;
    }
    public static List<String> reduceListToTwoNumbers(List<String> listOfNumbers){
            List<String> reducedArrayList = new ArrayList<>();
        for (String value : listOfNumbers){
            var asd = new StringBuilder(value);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(asd.charAt(0));
            stringBuilder.append(asd.charAt(asd.length()-1));
            reducedArrayList.add(stringBuilder.toString());
        }
        return reducedArrayList;
    }

    public static int getFinalNumber(List<String> listOfTwoNumbers){
        int finalNumber = 0;
        for (String value : listOfTwoNumbers){
            finalNumber = finalNumber + Integer.parseInt(value);
        }
        return finalNumber;
    }
}
