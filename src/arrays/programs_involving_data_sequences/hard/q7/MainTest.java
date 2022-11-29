package arrays.programs_involving_data_sequences.hard.q7;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static org.junit.Assert.assertArrayEquals;

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
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        SquareUp.main(new String[0]);
    }

    public static int[] sq(int[] arr) {
        int[] input = arr.clone();
        for (int i = 0; i < input.length; i++)
            input[i] = (int) Math.pow(input[i], 2);
        return input;
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-10000, 10000, n)),
                Arguments.of(generateRandomArray(-10000, 10000, n)),
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
                Arguments.of(generateRandomArray(-10000, 10000, 10000)),
                Arguments.of(generateRandomArray(-10000, 10000, 10000)),
                Arguments.of(generateRandomArray(-10000, 10000, 1000)),
                Arguments.of(generateRandomArray(-1, 2, 10000)),
                Arguments.of(replicateArray(1, 10000)),
                Arguments.of(replicateArray(0, 10000)),
                Arguments.of(replicateArray(10000, 10000))
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctFibonacciMaker(int[] input) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(SquareUp.class, "doubler", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your doubler method does not return the correct array of squared integers.");
        Object output = m.callMethod();
        assertArrayEquals((int[]) output, sq(input));
    }

}
