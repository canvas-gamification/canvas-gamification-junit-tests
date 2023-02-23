package arrays.programs_involving_data_sequences.hard.q5;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    private static final int inputLength = 8;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(0, 10, inputLength)) + 4;
        return new Clause[]{
                new StringLiteral("Enter 8 numbers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a number to search for:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Returned index: "),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("index")
        };
    }

    public void runMain() {
        FindThatNumber.main(new String[0]);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 100, 11, -45, 7, -3, 0, 9, 4, -12, 0, 4}, 4, 12),
                Arguments.of(new int[]{0, 4, 2, 5, 1, 5, 2, 6, 4, 5}, 0, 0),
                Arguments.of(new int[]{0, 11, 4, 2, 6, 3, 11, 6, 7, 11, 9, 9, 0}, 2, 3),
                Arguments.of(new int[]{1, 5, 3, 7, 423, 3, 7, 2, 10, 23, 342, 3, 5, 2}, 11, -1),
                Arguments.of(ArrayUtil.generateAscendingArray(10, 25, 2), 27, -1),
                Arguments.of(ArrayUtil.replicateArray(15, 416), 15, 415)
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(ArrayUtil.generateAscendingArray(10, inputLength, 2), 11, -1),
                Arguments.of(ArrayUtil.replicateArray(39, inputLength), 39, inputLength - 1),
                Arguments.of(ArrayUtil.generateAscendingArray(67, inputLength), 69, 2),
                Arguments.of(ArrayUtil.generateAscendingArray(129, inputLength), 129, 0),
                Arguments.of(ArrayUtil.generateRandomArray(0, 100, inputLength), 549, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctFindTheLastMethod(int[] arr, int search, int index) throws Throwable {
        Object[][] arguments = {
                {arr, int[].class},
                {search, int.class}
        };
        MethodTest m = new MethodTest(FindThatNumber.class, "findTheLast", arguments);
        Object outputIndex = m.callMethod();
        CustomAssertions._assertEquals(index, outputIndex, "Your findTheLast method does not find the index of last occurrence of a number in an array.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsCorrectOutput(int[] input, int target, int index) {
        runWithInput(ArrayUtil.arrayToInput(input) + target);
        assertEquals(index, Integer.parseInt(getItemByName("index")), "Your program does not correctly identify and print the index of the target integer in the array.");
    }
}
