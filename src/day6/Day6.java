package day6;

import utils.Utils;

import java.util.ArrayList;

public class Day6 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day6\\input.txt");

    private static int time = inputArrayList.indexOf("Time:");
    private static int distance = inputArrayList.indexOf("Distance:");

    private static int finalNumber = 1;

    public static void main(String[] args) {
        for (int i = time+1; i < distance; i++){
            finalNumber = finalNumber*getTraveledDistance(Integer.parseInt(inputArrayList.get(i)), Integer.parseInt(inputArrayList.get(i+distance)));
        }

        System.out.println(finalNumber);
    }

    public static int getTraveledDistance(int maxTime, int maxDistance){
        int successfulAttempts=0;
        for (int i=1; i < maxTime; i++){
            if (i*(maxTime-i) > maxDistance){
                successfulAttempts++;
            }
        }
        return successfulAttempts;
    }
}
