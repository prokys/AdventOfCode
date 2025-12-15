package AOC2025.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day5 {

    static List<Long> ranges;
    static List<Long> ingredients;

    public static int partOne(List<String> input){

        int finalNumber = 0;
        splitList(input);

        for (long ingredient : ingredients){
            for (int i = 0; i < ranges.size(); i+=2) {
                if (ingredient >= ranges.get(i) && ingredient <= ranges.get(i+1)){
                    finalNumber++;
                    break;
                }
            }
        }

        return finalNumber;
    }

    public static void splitList(List<String> input){

        int firstIngredient = 0;
        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).contains("-")) {
                firstIngredient = i;
                break;
            }
        }
        ranges = new ArrayList<>();
        ingredients = new ArrayList<>();

        for (int i = 0; i < firstIngredient; i++) {
            String line = input.get(i);
            int dash = line.indexOf('-');
            ranges.add(Long.parseLong(line.substring(0,dash)));
            ranges.add(Long.parseLong(line.substring(dash+1)));
        }
        for (int i = firstIngredient; i < input.size(); i++) {
            ingredients.add(Long.parseLong(input.get(i)));
        }
    }
}
