package day7;

import utils.CardDeckComparator;
import utils.Utils;

import java.util.*;

public class Day7 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\day7\\input.txt");
    public static List<String> fives = new ArrayList<String>();
    public static List<String> fours = new ArrayList<String>();
    public static List<String> fullHouses = new ArrayList<String>();
    public static List<String> threes = new ArrayList<String>();
    public static List<String> twoTwos = new ArrayList<String>();
    public static List<String> twos = new ArrayList<String>();
    public static List<String> singles = new ArrayList<String>();

    public static List<String> finalArrayList = new ArrayList<String>();
    public static int finalNumber = 0;

    public static void main(String[] args) {
        sortByCombinations();
        sortCombinationsByCardStrength();
        mergeLists();
        getFinalNumber();
        System.out.println(finalNumber);

    }

    public static int getNumberOfAppearances(String hand){
        long countChars= 0;
        for (char card:hand.toCharArray()) {
            countChars = countChars + (hand.chars().filter(ch -> ch==card).count());
        }
         return (int) countChars;
    }

    public static void sortByCombinations(){
        for (int i = 0; i<inputArrayList.size() ; i+=2) {
            switch (getNumberOfAppearances(inputArrayList.get(i))) {
                case 25 -> fives.add(inputArrayList.get(i));
                case 17 -> fours.add(inputArrayList.get(i));
                case 13 -> fullHouses.add(inputArrayList.get(i));
                case 11 -> threes.add(inputArrayList.get(i));
                case 9 -> twoTwos.add(inputArrayList.get(i));
                case 7 -> twos.add(inputArrayList.get(i));
                case 5 -> singles.add(inputArrayList.get(i));
            }
        }
    }
    public static void sortCombinationsByCardStrength(){
        fives.sort(new CardDeckComparator());
        fours.sort(new CardDeckComparator());
        fullHouses.sort(new CardDeckComparator());
        threes.sort(new CardDeckComparator());
        twoTwos.sort(new CardDeckComparator());
        twos.sort(new CardDeckComparator());
        singles.sort(new CardDeckComparator());
    }
    public static void mergeLists(){
        finalArrayList.addAll(singles);
        finalArrayList.addAll(twos);
        finalArrayList.addAll(twoTwos);
        finalArrayList.addAll(threes);
        finalArrayList.addAll(fullHouses);
        finalArrayList.addAll(fours);
        finalArrayList.addAll(fives);
    }
    public static void getFinalNumber(){
        for (int i = 0; i<finalArrayList.size(); i++){
            int indexOfRank = inputArrayList.indexOf(finalArrayList.get(i));
            finalNumber = finalNumber + ((i+1)*Integer.parseInt(inputArrayList.get(indexOfRank+1)));

        }
    }
}
