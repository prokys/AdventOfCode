package AOC2025.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

import static AOC2025.day6.Day6.partOne;

public class Day6Test {

    static Stream<Arguments> data() {
        List<List<String>> input = Utils.readFileLinesAndStoreValues("src/main/java/AOC2025/day6/input.txt");
        return Stream.of(
                Arguments.of(List.of(
                        List.of("123" ,"328", "51", "64"),
                        List.of("45", "64", "387", "23"),
                        List.of("6", "98", "215", "314"),
                                List.of("*",   "+",   "*",   "+"  )),
                        4277556),
                Arguments.of(input, 4412382293768L)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testPartOne(List<List<String>> input, long result){
        Assertions.assertEquals(result, partOne(input));
    }
}
