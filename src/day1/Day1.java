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
        reduceArrayToNumbers(inputArray);
        String[] numbersArray = numbersArrayList.toArray(new String[0]);
        reduceArrayToTwoNumbers(numbersArray);
        String[] twoNumbersArray = twoNumbersArrayList.toArray(new String[0]);
        printFinalNumber(twoNumbersArray);
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
                if(Character.isDigit(asd.charAt(y))){
                    stringBuilder.append(asd.charAt(y));
                }
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
