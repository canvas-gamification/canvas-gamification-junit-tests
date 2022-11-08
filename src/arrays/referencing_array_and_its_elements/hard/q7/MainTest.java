package arrays.referencing_array_and_its_elements.hard.q7;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 4 6 21 48 42 89 2 0 91";
        return new Clause[]{
                new StringLiteral("Enter an array of " + n + " integers to reverse:"),
                new NewLine(),
                new StringLiteral("The reverse of the array is:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        TakeItBackNow.main(new String[0]);
    }

    public static String reverse(int[] a) {
        String ans = "";
        for (int i = a.length - 1; i >= 0; i--)
            ans += a[i] + " ";
        return ans.trim();
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
    void correctMainMethod(int[] input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly reverse the array";
        runWithInput(
                arrayToInput(input),
                new Clause[]{
                        new StringLiteral(reverse(input))
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
    void correctSplitHalfMethod(int[] input) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
        };
        MethodTest m = new MethodTest(TakeItBackNow.class, "Rev", arguments);
        m.setIncorrectMethodStructureErrorMessage("Your Rev method does not correctly reverse the array");
        Object output = m.callMethod();
        assertEquals(output, reverse(input));
    }


}