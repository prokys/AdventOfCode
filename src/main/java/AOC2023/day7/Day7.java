package AOC2023.day7;

import AOC2023.utils.CardDeckComparator;
import AOC2023.utils.Utils;

import java.util.*;

public class Day7 {
    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day7\\input.txt");
    public static List<String> fives = new ArrayList<>();
    public static List<String> fours = new ArrayList<>();
    public static List<String> fullHouses = new ArrayList<>();
    public static List<String> threes = new ArrayList<>();
    public static List<String> twoTwos = new ArrayList<>();
    public static List<String> twos = new ArrayList<>();
    public static List<String> singles = new ArrayList<>();
    private static final Map<Character, Integer> customOrder = new HashMap<>();

    public static List<String> finalArrayList = new ArrayList<>();
    public static int finalNumber = 0;

    public static void main(String[] args) {
        partOne();
        partTwo();

    }
    public static void partOne(){
        sortByCombinations();
        createCustomOrder1();
        sortCombinationsByCardStrength();
        mergeLists();
        getFinalNumber();
        System.out.println(finalNumber);
        resetValues();
    }
    public static void partTwo(){
        sortByCombinations();
        checkListForJokersAndMoveThem(fours, fives);
        checkListForJokersAndMoveThem(fullHouses, fives);
        checkListForJokersAndMoveThem(threes, fours);
        checkListForJokersAndMoveThemForTwoTwos(twoTwos, fullHouses, fours);
        checkListForJokersAndMoveThem(twos, threes);
        checkListForJokersAndMoveThem(singles, twos);
        createCustomOrder2();
        sortCombinationsByCardStrength();
        mergeLists();
        getFinalNumber();
        System.out.println(finalNumber);
    }

    public static void resetValues(){
        finalNumber = 0;
        finalArrayList.clear();
        fives.clear();
        fours.clear();
        fullHouses.clear();
        threes.clear();
        twoTwos.clear();
        twos.clear();
        singles.clear();
        customOrder.clear();
    }
    public static void checkListForJokersAndMoveThem(List<String> listToCheck, List<String> listToAdd){
        List<String> valuesToRemove = new ArrayList<>();

        for (String hand : listToCheck){
            if (getNumberOfJokerCards(hand)>0){
                listToAdd.add(hand);
                valuesToRemove.add(hand);
            }
        }
        listToCheck.removeAll(valuesToRemove);
    }
    public static void checkListForJokersAndMoveThemForTwoTwos(List<String> listToCheck, List<String> listToAddFullHouse, List<String> listToAddFours){
        List<String> valuesToRemove = new ArrayList<>();

        for (String hand : listToCheck){
            if (getNumberOfJokerCards(hand)==1){
                listToAddFullHouse.add(hand);
                valuesToRemove.add(hand);
            } else if (getNumberOfJokerCards(hand)==2) {
                listToAddFours.add(hand);
                valuesToRemove.add(hand);
            }
        }
        listToCheck.removeAll(valuesToRemove);
    }

    public static int getNumberOfJokerCards(String hand){
        long countChars = 0;
        countChars = countChars + (hand.chars().filter(ch -> ch=='J').count());
        return (int) countChars;
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
        CardDeckComparator cardDeckComparator = new CardDeckComparator(customOrder);
        fives.sort(cardDeckComparator);
        fours.sort(cardDeckComparator);
        fullHouses.sort(cardDeckComparator);
        threes.sort(cardDeckComparator);
        twoTwos.sort(cardDeckComparator);
        twos.sort(cardDeckComparator);
        singles.sort(cardDeckComparator);
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

    public static void createCustomOrder1(){
        customOrder.put('2', 2);
        customOrder.put('3', 3);
        customOrder.put('4', 4);
        customOrder.put('5', 5);
        customOrder.put('6', 6);
        customOrder.put('7', 7);
        customOrder.put('8', 8);
        customOrder.put('9', 9);
        customOrder.put('T', 10);
        customOrder.put('J', 11);
        customOrder.put('Q', 12);
        customOrder.put('K', 13);
        customOrder.put('A', 14);
    }

    public static void createCustomOrder2(){
        customOrder.put('J', 1);
        customOrder.put('2', 2);
        customOrder.put('3', 3);
        customOrder.put('4', 4);
        customOrder.put('5', 5);
        customOrder.put('6', 6);
        customOrder.put('7', 7);
        customOrder.put('8', 8);
        customOrder.put('9', 9);
        customOrder.put('T', 10);
        customOrder.put('Q', 12);
        customOrder.put('K', 13);
        customOrder.put('A', 14);
    }
}
