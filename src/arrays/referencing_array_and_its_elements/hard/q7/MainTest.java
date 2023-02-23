package arrays.referencing_array_and_its_elements.hard.q7;

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

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(-100, 100, n));
        return new Clause[]{
                new StringLiteral("Enter an array of " + n + " integers to reverse:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The reverse of the array is:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        TakeItBackNow.main(new String[0]);
    }

    public static int[] reverse(int[] a) {
        int[] ans = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--)
            ans[a.length - i - 1] = a[i];
        return ans;
    }

    static Stream<Arguments> mainInputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n)),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n)),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, n))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printsCorrectOutput(int[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly reverse the array.";
        runWithInput(
                arrayToInput(input),
                new Clause[]{
                        new StringLiteral(arrayToInput(reverse(input)))
                }
        );
    }


    static Stream<Arguments> InputProvider() {
        return Stream.of(
                Arguments.of(generateRandomArray(-1000000000, 1000000000, 10)),
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{1, 2}),
                Arguments.of(generateRandomArray(-1000000000, 1000000000, 10000))
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctRevMethod(int[] input) throws Throwable {
        int[] ans = reverse(input);
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(TakeItBackNow.class, "rev", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output, "Your rev method does not correctly reverse the array.");
    }

}
