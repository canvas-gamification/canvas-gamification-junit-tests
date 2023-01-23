package arrays.programs_involving_data_sequences.hard.q7;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-10, 10, n));
        return new Clause[]{
                new StringLiteral("Enter an array of " + n + " integers to be squared:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The squared array is:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        SquareUp.main(new String[0]);
    }

    public static int[] sq(int[] arr) {
        int[] input = arr.clone();
        for(int i = 0; i < arr.length; i ++)
            input[i]*=input[i];
        return input;
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-100, 100, n)),
                Arguments.of(generateRandomArray(-1000, 1000, n)),
                Arguments.of(generateRandomArray(-10000, 10000, n)),
                Arguments.of(generateRandomArray(-1, 2, n)),
                Arguments.of(replicateArray(1, n)),
                Arguments.of(replicateArray(0, n)),
                Arguments.of(replicateArray(10000, n))


        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printCorrectOutput(int[] a) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct sequence of squared array.";
        runWithInput(arrayToInput(a), new Clause[]{
                new StringLiteral(arrayToInput(sq(a)))
        });
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-100, 100, 100)),
                Arguments.of(generateRandomArray(-1000, 1000, 1000)),
                Arguments.of(generateRandomArray(-10000, 10000, 1000)),
                Arguments.of(generateRandomArray(-1, 2, 1000)),
                Arguments.of(replicateArray(1, 1000)),
                Arguments.of(replicateArray(0, 1000)),
                Arguments.of(replicateArray(10000, 1000)),
                Arguments.of(new int[] {}),
                Arguments.of(new int[] {-1, 1}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(new int[] {1, -1, 1, -1, 1}),
                Arguments.of(new int[] {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctFibonacciMaker(int[] input) throws Throwable {
        int[] ans = sq(input);
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(SquareUp.class, "doubler", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output, "Your doubler method does not return the correct array of squared integers.");
    }

}
