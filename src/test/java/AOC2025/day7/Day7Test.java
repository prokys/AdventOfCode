package AOC2025.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day7.Day7.partOne;
import static AOC2025.day7.Day7.partTwo;

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
                Arguments.of(input, 1662)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, int result){
        Assertions.assertEquals(result, partOne(input));
    }

    static Stream<Arguments> dataTwo() {
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
                        "..............."), 40),
                Arguments.of(input, 40941112789504L)
        );
    }

    @ParameterizedTest
    @MethodSource("dataTwo")
    public void testPartTwo(List<String> input, long result){
        Assertions.assertEquals(result, partTwo(input));
    }

}
