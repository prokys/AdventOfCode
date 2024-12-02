package AOC2023.utils;

import java.io.File;
import java.util.ArrayList;
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
    public static void printArray(String[] array){
        for (int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
