package day8;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day8 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\day8\\input.txt");
    public static List<String> node = new ArrayList<>();
    public static List<String> leftPath = new ArrayList<>();
    public static List<String> rightPath = new ArrayList<>();

    public static String instructions = inputArrayList.get(0);
    public static String currentPosition = "AAA";
    public static String finalPosition = "ZZZ";
    public static int finalNumber = 0;


    public static void main(String[] args) {
        partOne();
    }

    public static void partOne() {
        splitInputIntoSeparateLists();

        for (int i = 0; i < instructions.length(); i++){
            finalNumber++;
            int indexOfNode = node.indexOf(currentPosition);
            if (instructions.charAt(i)== 'L'){
//                System.out.println(instructions.charAt(i));
                currentPosition = leftPath.get(indexOfNode);
            }else {
//                System.out.println(instructions.charAt(i));
                currentPosition = rightPath.get(indexOfNode);
            }
            if (currentPosition.equals(finalPosition)){
                System.out.println(finalNumber);
                break;
            }
            if(i == instructions.length()-1){
                i=-1;
            }
        }
    }

    public static void splitInputIntoSeparateLists(){
        for (int i = 1; i<inputArrayList.size(); i+=4){
            node.add(inputArrayList.get(i));
            leftPath.add(inputArrayList.get(i+2).replace('(', ' ').replace(',', ' ').trim());
            rightPath.add(inputArrayList.get(i+3).replace(')', ' ').trim());
        }
    }
}
