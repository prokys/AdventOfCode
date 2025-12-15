package AOC2025.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day5.Day5.partOne;

public class Day5Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileAndStoreValues("src/main/java/AOC2025/day5/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        "3-5",
                        "10-14",
                        "16-20",
                        "12-18",
                        "1",
                        "5",
                        "8",
                        "11",
                        "17",
                        "32") , 3),
                Arguments.of(input, 1489)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, int result){
        Assertions.assertEquals(result, partOne(input));
    }
}
