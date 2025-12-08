package AOC2025.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static AOC2025.day1.Day1.partOne;
import static AOC2025.day1.Day1.partTwo;
import static utils.Utils.readFileAndStoreValues;

public class Day1Test {

    static String[] inputList = readFileAndStoreValues("src/main/java/AOC2025/day1/input.txt").toArray(new String[0]);

    static Stream<Arguments> dataPart1() {
        return Stream.of(
                Arguments.of(new String[]{"L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L282"}, 3),
                Arguments.of(new String[]{"P1"}, 0),
                Arguments.of(new String[]{"L50", "L100", "L100", "L100", "L100", "L100", "L100"}, 7),
                Arguments.of(inputList, 1145)
        );
    }

    @ParameterizedTest
    @MethodSource({"dataPart1"})
    public void testDay1PartOne(String[] input, int result){
        Assertions.assertEquals(result, partOne(input));
    }

    static Stream<Arguments> dataPart2() {

        return Stream.of(
                Arguments.of(new String[]{"L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"}, 6),
                Arguments.of(new String[]{"P1"}, 0),
                Arguments.of(new String[]{"L50", "L100", "L100", "L100", "L100", "L100", "L100"}, 7),
                Arguments.of(new String[]{"R50", "R100", "R100", "R100", "R100", "R100", "R100"}, 7),
                Arguments.of(new String[]{"L50", "L1"}, 1),
                Arguments.of(new String[]{"R50", "R1"}, 1),
                Arguments.of(new String[]{"L50", "L1", "L120"}, 2),
                Arguments.of(new String[]{"L100", "L100", "L100"}, 3),
                Arguments.of(new String[]{"R100", "R100", "R100"}, 3),
                Arguments.of(new String[]{"L50", "R1", "L2", "R1", "R1"}, 3),
                Arguments.of(new String[]{"L450"}, 5),
                Arguments.of(inputList, 6561)
        );
    }

    @ParameterizedTest
    @MethodSource({"dataPart2"})
    public void testDay1PartTwo(String[] input, int result){
        Assertions.assertEquals(result, partTwo(input));
    }

}
