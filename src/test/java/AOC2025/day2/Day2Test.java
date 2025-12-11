package AOC2025.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

import static AOC2025.day2.Day2.partOne;
import static AOC2025.day2.Day2.partTwo;

public class Day2Test {

    static Stream<Arguments> data() {
        String input = Utils.readFileAndStoreValues("src/main/java/AOC2025/day2/input.txt").get(0);
        return Stream.of(
                Arguments.of("11-22,", 33),
                Arguments.of("95-115,", 99),
                Arguments.of("998-1012,", 1010),
                Arguments.of("1188511880-1188511890,", 1188511885),
                Arguments.of("222220-222224,", 222222),
                Arguments.of("1698522-1698528,", 0),
                Arguments.of("446443-446449,", 446446),
                Arguments.of("38593856-38593862,", 38593859),
                Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,", 1227775554),
                Arguments.of(input, 30323879646L)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(String input, long result){
        Assertions.assertEquals(result, partOne(input));
    }


    static Stream<Arguments> dataTwo() {
        String input = Utils.readFileAndStoreValues("src/main/java/AOC2025/day2/input.txt").get(0);
        return Stream.of(
                Arguments.of("100-999,", 4995),
                Arguments.of("11-22,", 33),
                Arguments.of("95-115,", 210),
                Arguments.of("998-1012,", 2009),
                Arguments.of("1188511880-1188511890,", 1188511885),
                Arguments.of("222220-222224,", 222222),
                Arguments.of("1698522-1698528,", 0),
                Arguments.of("446443-446449,", 446446),
                Arguments.of("38593856-38593862,", 38593859),
                Arguments.of("565653-565659,", 565656),
                Arguments.of("824824821-824824827,", 824824824),
                Arguments.of("2121212118-2121212124,", 2121212121),
                Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124,", 4174379265L),
                Arguments.of(input, 43872163557L)
        );
    }
    @ParameterizedTest
    @MethodSource("dataTwo")
    public void testPartTwo(String input, long result){
        Assertions.assertEquals(result, partTwo(input));
    }
}
