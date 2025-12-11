package AOC2025.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day3.Day3.partOne;

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
}
