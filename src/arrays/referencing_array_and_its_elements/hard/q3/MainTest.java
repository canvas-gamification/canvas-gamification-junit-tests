package arrays.referencing_array_and_its_elements.hard.q3;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.*;
import static java.lang.System.arraycopy;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-100, 100, n));
        return new Clause[]{
                new StringLiteral("Enter " + n + " positive integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The array with only even numbers is:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" ")),
        };
    }

    public void runMain() {
        Even.main(new String[0]);
    }

    public static int[] getEven(int[] arr) {
        int[] ev = new int[arr.length];
        int t = 0;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] % 2 == 0)
                ev[t ++] = arr[i];
        }
        int[] ans = new int[t];
        arraycopy(ev, 0, ans, 0, t);
        return ans;
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(1, 10, n)),
                Arguments.of(generateRandomArray(1, 1000, n)),
                Arguments.of(generateRandomArray(1, 1000000000, n)),
                Arguments.of(generateAscendingArray(1, n, 2)),
                Arguments.of(generateAscendingArray(2, n, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    public void correctMainMethod(int[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your main method does not print the correct array of even numbers.";
        runWithInput(arrayToInput(input), new Clause[]{
                new StringLiteral(arrayToInput(getEven(input)))
        });
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 5, 91}),
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{1, 3, 5}),
                Arguments.of(new int[]{2, 4, 6}),
                Arguments.of(new int[]{5, 3, 1, 6, 4, 2}),
                Arguments.of(generateRandomArray(1, 1000000000, 1000)),
                Arguments.of(generateAscendingArray(1, 1000, 2)),
                Arguments.of(generateAscendingArray(2, 1000, 2))
        );
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctEvenMethod(int[] input) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(Even.class, "even", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(getEven(input), output,
                "Your even method does not correctly create a new array containing the even values from the input array.");
    }
}
