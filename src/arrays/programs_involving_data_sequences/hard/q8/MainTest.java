package arrays.programs_involving_data_sequences.hard.q8;

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
                new StringLiteral("Enter an array of " + n + " integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The result of multiplied array is:"),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        MultItUp.main(new String[0]);
    }

    public static int[] mul(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int value = input[i] * i;
            input[i] = value;
        }
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
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct multiplied array.";
        runWithInput(arrayToInput(a), new Clause[]{
                new StringLiteral(arrayToInput(mul(a)))
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
        MethodTest m = new MethodTest(MultItUp.class, "productMaker", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your productMaker method does not return the correct multiplied array");
        Object output = m.callMethod();
        assertArrayEquals((int[]) output, mul(input));
    }
}
