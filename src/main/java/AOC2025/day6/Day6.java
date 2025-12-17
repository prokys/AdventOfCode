package AOC2025.day6;

import java.util.List;

public class Day6 {

    public static long partOne(List<List<String>> input){

        long finalNumber = 0;

        for (int i = 0; i < input.get(0).size(); i++) {
            long number = 0;
            for (int j = 0; j < input.size()-1; j++) {
                if (input.get(input.size()-1).get(i).equals("+")){
                    number = number + Integer.parseInt(input.get(j).get(i));
                }else {
                    if (number == 0){
                        number = Integer.parseInt(input.get(j).get(i));
                    }else {
                        number = number * Integer.parseInt(input.get(j).get(i));
                    }
                }

            }
            finalNumber = finalNumber+number;
        }


        return finalNumber;
    }
}
