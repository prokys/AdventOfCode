package day4;

import utils.Utils;

import java.util.ArrayList;

public class Day4 {
    public static ArrayList<String> inputArrayList = Utils.readFileAndStoreValues("src\\day4\\input.txt");
    public static ArrayList<Integer> scratchCardNumbersList = new ArrayList<Integer>();

    public static int firstWinnersNumberIndex;
    public static int dividerNumberIndex;
    public static int lastNumberIndex;
    public static int numberOfRows;

    public static int numberOfWiningNumbers;
    public static int finalNumber;

    public static void main (String args[]){
        partOne();
        partTwo();

}

    public static void partOne(){
        setBaseValues();
        for (int i = 0; i < numberOfRows; i++) {
            for (int y = firstWinnersNumberIndex; y < dividerNumberIndex; y++) {
                for (int z = dividerNumberIndex + 1; z <= lastNumberIndex; z++) {
                    if (inputArrayList.get(y).equals(inputArrayList.get(z))) {
                        numberOfWiningNumbers++;
                    }
                }
            }
            finalNumber = finalNumber + (int) Math.pow(2, numberOfWiningNumbers - 1);
            firstWinnersNumberIndex = firstWinnersNumberIndex + 38;
            dividerNumberIndex = dividerNumberIndex + 38;
            lastNumberIndex = lastNumberIndex + 38;
            numberOfWiningNumbers = 0;
        }
        System.out.println(finalNumber);
    }
    public static void partTwo(){
        setBaseValues();
        addBaseNumberOfScratchcards();
        for (int i = 0; i < numberOfRows; i++) {
            for (int y = firstWinnersNumberIndex; y < dividerNumberIndex; y++) {
                for (int z = dividerNumberIndex + 1; z <= lastNumberIndex; z++) {
                    if (inputArrayList.get(y).equals(inputArrayList.get(z))) {
                        numberOfWiningNumbers++;
                    }
                }
            }
            for (int w=0; w<numberOfWiningNumbers; w++){
                if(i+w+1<numberOfRows){
                    scratchCardNumbersList.set((i+w+1), scratchCardNumbersList.get(i+w+1)+(1*scratchCardNumbersList.get(i)));
                }
            }


            firstWinnersNumberIndex = firstWinnersNumberIndex + 38;
            dividerNumberIndex = dividerNumberIndex + 38;
            lastNumberIndex = lastNumberIndex + 38;
            numberOfWiningNumbers = 0;
        }
        getFinalNumber();
        System.out.println(finalNumber);
    }

    public static void addBaseNumberOfScratchcards(){
        for (int i=0;i<numberOfRows;i++){
            scratchCardNumbersList.add(1);
        }
    }

    public static void getFinalNumber(){
        for (int i=0;i<numberOfRows;i++){
            finalNumber = finalNumber+scratchCardNumbersList.get(i);
        }
    }

    public static void setBaseValues(){
        firstWinnersNumberIndex = 2;
        dividerNumberIndex = 12;
        lastNumberIndex = 37;
        numberOfRows = 205;

        numberOfWiningNumbers=0;
        finalNumber=0;

    }

}
