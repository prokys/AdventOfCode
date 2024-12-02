package AOC2023.day1;

import AOC2023.day1.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Day1Test {

    @Test
    void reduceListToNumbers() {
        String[] array = {"123adsasdas", "1s2sd3", "ycxyxcyx123", "&#đĐđĐ"};
        List<String>numbersArrayList = Day1.reduceListToNumbers(Arrays.stream(array).toList());
        String[] desiredArrayList = {"123", "123", "123", ""};
        Assertions.assertEquals(Arrays.stream(desiredArrayList).toList(), numbersArrayList);
    }

    @Test
    void reduceListToNumbersWithNumbersAsString() {
        String[] array = {"123one", "1one2sd3", "ycxyxcyxone123", "&#đĐđĐ", "twone", "sevenine", "sevennine"};
        List<String>numbersArrayList = Day1.reduceListToNumbersWithNumbersAsString(Arrays.stream(array).toList());
        String[] desiredArrayList = {"1231", "1123", "1123","", "21", "79", "79"};
        Assertions.assertEquals(Arrays.stream(desiredArrayList).toList(), numbersArrayList);
    }

    @Test
    void reduceListToTwoNumbers() {
        String[] array = {"123", "13", "32131", "as", "asd"};
        List<String>numbersArrayList = Day1.reduceListToTwoNumbers(Arrays.stream(array).toList());
        String[] desiredArrayList = {"13", "13", "31", "as", "ad"};
        Assertions.assertEquals(Arrays.stream(desiredArrayList).toList(), numbersArrayList);
    }

    @Test
    void getFinalNumber() {
        String[] array = {"1", "2", "3", "10", "20", "30"};
        int finalNumber = Day1.getFinalNumber(Arrays.stream(array).toList());
        int desiredFinalNumber = 66;
        Assertions.assertEquals(desiredFinalNumber, finalNumber);
    }
}