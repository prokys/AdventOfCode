package AOC2023.day12;

import AOC2023.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12 {

    public static List<String> inputArrayList = Utils.readFileAndStoreValues("src\\main\\java\\AOC2023\\day12\\input.txt");

    public static List<String> finalList = new ArrayList<>();
    public static List<String> generatedList = new ArrayList<>();

    public static int finalNumber = 0;

    public static void main(String[] args) {

        String test0 = "..#.#.##...###.";
        String test1 = "..#..#.##..###.";
        String test2 = "...#.#.##..###.";
        String test3 = "..#.#..##..###.";
        String test4 = "..#.#.##....###";
        String test5 = "..#..#.##...###";
        String test6 = "...#.#.##...###";
        String test7 = "...#.#.##...###";
        String test8 = "#.#.##.###";
        String test9 = "#.#.##.####";
        String test10 = "##.##.##.###";
        System.out.println(doesItMatch(test0));
        System.out.println(doesItMatch(test1));
        System.out.println(doesItMatch(test2));
        System.out.println(doesItMatch(test3));
        System.out.println(doesItMatch(test4));
        System.out.println(doesItMatch(test5));
        System.out.println(doesItMatch(test6));
        System.out.println(doesItMatch(test7));
        System.out.println(doesItMatch(test8));
        System.out.println(doesItMatch(test9));
        System.out.println(doesItMatch(test10));


        for (String value : finalList){
            System.out.println(value);
        }
        System.out.println(finalList.size());
    }

    public static List<String> generatePossibilities(String input, List<Integer> questionMarks){
        List<String> possibleVariants = new ArrayList<>();



        return possibleVariants;
    }

    public static List<Integer> getQuestionMarkPositions(String input){

        List<Integer> questionMarkPositions = new ArrayList<>();

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '?'){
                questionMarkPositions.add(i);
            }
        }
        return questionMarkPositions;
    }

    public static boolean doesItMatch(String input){
//        Pattern pattern = Pattern.compile("\\.?#[^#]+#[^#]+##[^#]+###\\.?");
        Pattern pattern = Pattern.compile("^\\.*#\\.*[^#]+#\\.*[^#]+##\\.*[^#]+###\\.*$");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
