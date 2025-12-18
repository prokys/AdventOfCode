package AOC2025.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day7.Day7.partOne;

public class Day7Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileLinesAndStoreLines("src/main/java/AOC2025/day7/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        ".......S.......",
                                "...............",
                                ".......^.......",
                                "...............",
                                "......^.^......",
                                "...............",
                                ".....^.^.^.....",
                                "...............",
                                "....^.^...^....",
                                "...............",
                                "...^.^...^.^...",
                                "...............",
                                "..^...^.....^..",
                                "...............",
                                ".^.^.^.^.^...^.",
                                "..............."), 21),
                Arguments.of(input, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, int result){
        Assertions.assertEquals(result, partOne(input));
    }
}
