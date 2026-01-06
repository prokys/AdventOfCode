package AOC2025.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day8.Day8.partOne;

public class Day8Test {

    static Stream<Arguments> data() {
        List<String> input = Utils.readFileLinesAndStoreLines("src/main/java/AOC2025/day8/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        "162,817,812",
                        "57,618,57",
                        "906,360,560",
                        "592,479,940",
                        "352,342,300",
                        "466,668,158",
                        "542,29,236",
                        "431,825,988",
                        "739,650,466",
                        "52,470,668",
                        "216,146,977",
                        "819,987,18",
                        "117,168,530",
                        "805,96,715",
                        "346,949,466",
                        "970,615,88",
                        "941,993,340",
                        "862,61,35",
                        "984,92,344",
                        "425,690,689"), 40, 10),
                Arguments.of(input, 103488, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<String> input, int result, int pairs){
        Assertions.assertEquals(result, partOne(input, pairs));
    }
}
