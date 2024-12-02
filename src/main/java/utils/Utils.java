package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static ArrayList<String> readFileAndStoreValues(String path){
        ArrayList<String> inputArrayList = new ArrayList<String>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            do {
                inputArrayList.add(scanner.next());
            }while (scanner.hasNext());
        }
        catch(Exception e){
            System.out.println("File does not exist");
            e.printStackTrace();
        }
        return inputArrayList;
    }

    public static List<List<String>> readFileLinesAndStoreValues(String path){
        List<String> inputArrayList = new ArrayList<String>();
        List<List<String>> finalArrayList = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            do {
                inputArrayList.add(scanner.nextLine());
            }while (scanner.hasNext());
        }
        catch(Exception e){
            System.out.println("File does not exist");
            e.printStackTrace();
        }

        for (String s : inputArrayList) {
            Scanner scanner = new Scanner(s);
            List<String> tempList = new ArrayList<String>();
            do {
                tempList.add(scanner.next());
            } while (scanner.hasNext());
            finalArrayList.add(tempList);
        }
        return finalArrayList;
    }
    public static void printArray(String[] array){
        for (int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
