package AOC2025.day10;

import java.util.ArrayList;
import java.util.List;

public class Day10 {

    public static int partOne(List<String> input){

        int finalNumber = 0;
        for (String line : input){
            int clicks = 99999999;
            List<String> splitedList = getSplitedList(line);

            String resultString = splitedList.get(0);
            String resultStringNoBracket = resultString.substring(1,resultString.length()-1);

            List<Boolean> resultList = getResultList(resultStringNoBracket);

            List<String> buttonsList = getButtons(splitedList);

            List<List<String>> combinations = getCombinations(buttonsList);

            for (List<String> combination : combinations){
                List<Boolean> modifyList = getModifiedList(resultStringNoBracket);

                for (String comb: combination){
                    clickButtons(modifyList, comb);
                }
                if (listHasSameValues(resultList,modifyList)){
                        if (combination.size() < clicks){
                            clicks = combination.size();
                        }
                }
            }
            finalNumber = finalNumber + clicks;
        }
        return finalNumber;
    }

    private static List<Boolean> clickButtons(List<Boolean> modifyList, String buttonsNoBracket){

        for (int i = 0; i < buttonsNoBracket.length(); i++) {
            int positionToUpdate = Integer.parseInt(String.valueOf(buttonsNoBracket.charAt(i)));
            modifyList.set(positionToUpdate, !(modifyList.get(positionToUpdate)));
        }
        return modifyList;
    }

    private static List<List<String>> getCombinations(List<String> usableButtonsList) {
        List<List<String>> combinations = new ArrayList<>();

        for (int size = 1; size <= usableButtonsList.size(); size++) {
            backtrack(usableButtonsList, size, 0, new ArrayList<>(), combinations);
        }

        return combinations;
    }

    private static void backtrack(List<String> usableButtonsList, int size, int start, ArrayList<String> objects, List<List<String>> combinations) {

        if (objects.size() == size) {
            combinations.add(new ArrayList<>(objects));
            return;
        }

        for (int i = start; i < usableButtonsList.size(); i++) {
            objects.add(usableButtonsList.get(i));
            backtrack(usableButtonsList, size, i + 1, objects, combinations);
            objects.remove(objects.size() - 1);
        }

    }

    private static List<String> getButtons(List<String> splitedList) {
        List<String> buttonsList = new ArrayList<>();
            for (int i = 1; i < splitedList.size()-1; i++) {
                String buttons = splitedList.get(i);
                String buttonsNoBracket = buttons.substring(1, buttons.length() - 1);
                String dash = ",";
                buttonsNoBracket = buttonsNoBracket.replaceAll(dash, "");
                buttonsList.add(buttonsNoBracket);
            }
            return buttonsList;
    }

    private static List<String> getSplitedList(String line) {

        String regex = "\\s";
        return new ArrayList<>(List.of(line.split(regex)));
    }

    private static List<Boolean> getResultList(String noBracket) {
        List<Boolean> resultList = new ArrayList<>();
        for (int i = 0; i < noBracket.length(); i++){
            if (noBracket.charAt(i) == '#'){
                resultList.add(true);
            }else resultList.add(false);
        }

        return resultList;
    }

    private static List<Boolean> getModifiedList(String noBracket) {
        List<Boolean> modifyList = new ArrayList<>();
        for (int i = 0; i < noBracket.length(); i++){
            modifyList.add(false);
        }
        return modifyList;
    }

    private static boolean listHasSameValues(List<Boolean> resultList, List<Boolean> modifyList) {

        for (int i = 0; i < resultList.size(); i++) {
            if (!(resultList.get(i) == modifyList.get(i))){
                return false;
            }
        }
        return true;
    }
}
