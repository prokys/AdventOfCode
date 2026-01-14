package AOC2025.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day10.Day10.partOne;

public class Day10Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileLinesAndStoreLines("src/main/java/AOC2025/day10/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
                        "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
                        "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
                ), 7),
                Arguments.of(input, 491)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, long result){
        Assertions.assertEquals(result, partOne(input));
    }
}
