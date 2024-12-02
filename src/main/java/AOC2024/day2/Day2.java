package AOC2024.day2;

import utils.Utils;

import java.util.List;

public class Day2 {
    public static List<List<String>> inputList = Utils.readFileLinesAndStoreValues("src/main/java/AOC2024/day2/input.txt");

    public static int finalNumber = 0;

    public static void main(String[] args) {

        partOne();

    }

    public static void partOne(){

        for (int i = 0; i < inputList.size(); i++) {

            int elementDiff = Integer.parseInt(inputList.get(i).get(0)) - Integer.parseInt(inputList.get(i).get(1));
            if (elementDiff > 0 && elementDiff <=3){
                boolean increasing = false;
                finalNumber = finalNumber + isRowSafe(inputList.get(i), increasing);
            } else if (elementDiff < 0 && elementDiff >= -3) {
                boolean increasing = true;
                finalNumber = finalNumber + isRowSafe(inputList.get(i), increasing);
            }
        }
        System.out.println(finalNumber);

    }

    public static int isRowSafe(List<String> list, boolean increasing){

        for (int i = 0; i < list.size()-1; i++) {
            int elementDiff = Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i+1));
            if (elementDiff > 0 && elementDiff <=3 && !increasing){

            } else if (elementDiff < 0 && elementDiff >= -3 && increasing) {

            } else return 0;
        }
        return 1;
    }

}
