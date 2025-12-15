package AOC2025.day5;

import utils.Range;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Day5 {

    static List<Range> ranges;
    static List<Long> ingredients;

    public static int partOne(List<String> input){

        int finalNumber = 0;
        splitList(input);

        for (long ingredient : ingredients){
            for (Range range : ranges) {
                if (ingredient >= range.getStart() && ingredient <= range.getEnd()) {
                    finalNumber++;
                    break;
                }
            }
        }

        return finalNumber;
    }

    public static long partTwo(List<String> input){

        long finalNumber = 0;
        List<Boolean> wasThereMerge;
        splitList(input);
        do {
            wasThereMerge = new ArrayList<>();
            for (Range range : ranges){
                for (Range rangeToMerge: ranges){
                    wasThereMerge.add(range.mergeRange(rangeToMerge));
                }
            }
        }while (wasThereMerge.contains(true));

        List<Range> finalRanges = new ArrayList<>(new HashSet<>(ranges));

        for (Range range : finalRanges){
            finalNumber = finalNumber + range.getSize();
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
            ranges.add(new Range(Long.parseLong(line.substring(0,dash)), Long.parseLong(line.substring(dash+1))));
        }
        for (int i = firstIngredient; i < input.size(); i++) {
            ingredients.add(Long.parseLong(input.get(i)));
        }
    }
}
