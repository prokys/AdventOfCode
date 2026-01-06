package AOC2025.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day9.Day9.partOne;

public class Day9Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileLinesAndStoreLines("src/main/java/AOC2025/day9/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        "7,1",
                        "11,1",
                        "11,7",
                        "9,7",
                        "9,5",
                        "2,5",
                        "2,3",
                        "7,3"), 50),
                Arguments.of(input, 4765757080L)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, long result){
        Assertions.assertEquals(result, partOne(input));
    }
}
