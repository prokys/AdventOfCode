package day1;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
    public static ArrayList<String> inputArrayList = new ArrayList<String>();
    public static ArrayList<String> numbersArrayList = new ArrayList<String>();
    public static ArrayList<String> twoNumbersArrayList = new ArrayList<String>();
    public static void main(String args[]){
        readFileAndStoreValues();
        String[] inputArray = inputArrayList.toArray(new String[0]);
//        System.out.println(inputArray[0]);
//        findNumbersInText(inputArray);
//        System.out.println(inputArray[0]);
        reduceArrayToNumbers(inputArray);
        String[] numbersArray = numbersArrayList.toArray(new String[0]);
//        System.out.println(numbersArray[0]);
        reduceArrayToTwoNumbers(numbersArray);
        String[] twoNumbersArray = twoNumbersArrayList.toArray(new String[0]);
//        System.out.println(twoNumbersArray[0]);
//        System.out.println(Integer.parseInt(twoNumbersArray[0]));
//        printArray(twoNumbersArray);
        printFinalNumber(twoNumbersArray);
    }

    public static void findNumbersInText(String[] array){
        for (int i=0; i<array.length; i++){
            array[i] = array[i].replaceAll("one", "1");
            array[i] = array[i].replaceAll("two", "2");
            array[i] = array[i].replaceAll("three", "3");
            array[i] = array[i].replaceAll("four", "4");
            array[i] = array[i].replaceAll("five", "5");
            array[i] = array[i].replaceAll("six", "6");
            array[i] = array[i].replaceAll("seven", "7");
            array[i] = array[i].replaceAll("eight", "8");
            array[i] = array[i].replaceAll("nine", "9");
        }
    }
    public static void readFileAndStoreValues(){
        try{
            File file = new File("src\\day1\\input.txt");
            Scanner scanner = new Scanner(file);
            do {
                inputArrayList.add(scanner.next());
            }while (scanner.hasNext());
        }
        catch(Exception e){
            System.out.println("File does not exist");
            e.printStackTrace();
        }
    }
    public static void reduceArrayToNumbers(String[] array){
        for (String value : array){
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
            numbersArrayList.add(stringBuilder.toString());
        }
    }
    public static void reduceArrayToTwoNumbers(String[] array){
        for (String value : array){
            var asd = new StringBuilder(value);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(asd.charAt(0));
            stringBuilder.append(asd.charAt(asd.length()-1));
            twoNumbersArrayList.add(stringBuilder.toString());
        }
    }

    public static void printFinalNumber(String[] array){
        int finalNumber = 0;
        for (String value : array){
            finalNumber = finalNumber + Integer.parseInt(value);
        }
        System.out.println(finalNumber);
    }
    public static void printArray(String[] array){
        for (int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
