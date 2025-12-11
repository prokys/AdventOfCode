package AOC2025.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day3.Day3.partOne;
import static AOC2025.day3.Day3.partTwo;

public class Day3Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileAndStoreValues("src/main/java/AOC2025/day3/input.txt");
        return Stream.of(
                Arguments.of(List.of("987654321111111") , 98),
                Arguments.of(List.of("811111111111119"), 89),
                Arguments.of(List.of("234234234234278"), 78),
                Arguments.of(List.of("818181911112111"), 92),
                Arguments.of(List.of("111111111111111"), 11),
                Arguments.of(List.of("999999999999999"), 99),
                Arguments.of(List.of("987654321111111","811111111111119","234234234234278","818181911112111","111111111111111","999999999999999"), 467),
                Arguments.of(input, 17343)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, int result){
        Assertions.assertEquals(result, partOne(input));
    }

    static Stream<Arguments> dataTwo() {
        List<String> input = Utils.readFileAndStoreValues("src/main/java/AOC2025/day3/input.txt");
        return Stream.of(
                Arguments.of(List.of("987654321111111") , 987654321111L),
                Arguments.of(List.of("811111111111119"), 811111111119L),
                Arguments.of(List.of("234234234234278"), 434234234278L),
                Arguments.of(List.of("818181911112111"), 888911112111L),
                Arguments.of(List.of("111111111111111"), 111111111111L),
                Arguments.of(List.of("999999999999999"), 999999999999L),
                Arguments.of(List.of("987654321111111","811111111111119","234234234234278","818181911112111","111111111111111","999999999999999"), 4233021889729L),
                Arguments.of(input, 172664333119298L)
        );
    }

    @ParameterizedTest
    @MethodSource("dataTwo")
    public void testPartTwo(List<String> input, long result){
        Assertions.assertEquals(result, partTwo(input));
    }
}
