package day6;

import utils.Utils;

import java.util.ArrayList;

public class Day6 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day6\\input.txt");

    private static int time = inputArrayList.indexOf("Time:");
    private static int distance = inputArrayList.indexOf("Distance:");

    private static long finalNumber = 1;

    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne(){
        for (int i = time+1; i < distance; i++){
            finalNumber = finalNumber*getTraveledDistance(Long.parseLong(inputArrayList.get(i)), Long.parseLong(inputArrayList.get(i+distance)));
        }
        System.out.println(finalNumber);
        finalNumber=1;
    }
    public static void partTwo(){
        long combinedTime = combineInput(time+1, distance);
        long combinedDistance = combineInput(distance+1, inputArrayList.size());
        System.out.println(getTraveledDistance(combinedTime, combinedDistance));
    }

    public static long getTraveledDistance(long maxTime, long maxDistance){
        int successfulAttempts=0;
        for (int i=1; i < maxTime; i++){
            if (i*(maxTime-i) > maxDistance){
                successfulAttempts++;
            }
        }
        return successfulAttempts;
    }
    public static long combineInput(int start, int end){
        String combined="";
        for (int i = start; i < end; i++){
            combined= combined+inputArrayList.get(i);
        }
        return Long.parseLong(combined);
    }
}
