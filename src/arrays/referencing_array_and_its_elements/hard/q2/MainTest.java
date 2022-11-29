package arrays.referencing_array_and_its_elements.hard.q2;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static global.utils.ArrayUtil.arrayToInput;
import static global.utils.ArrayUtil.generateRandomArray;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest extends BaseTest {
    // Java

    public static int n = 9;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = arrayToInput(generateRandomArray(1, 100, n + 1));
        return new Clause[]{
                new StringLiteral("Enter nine integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter a positive integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The first "),
                new IntegerLiteral("x"),
                new StringLiteral(" numbers of the array are:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };

    }

    public void runMain() {
        Remainder.main(new String[0]);
    }

    static Stream<Arguments> InputProvider() {
        int[] a1 = generateRandomArray(-1000, 1000, n);
        int[] a2 = generateRandomArray(-1000, 1000, n);
        int[] a3 = generateRandomArray(-1000, 1000, n);
        int[] a4 = generateRandomArray(-1000, 1000, n);
        int[] a5 = generateRandomArray(-1000, 1000, n);
        return Stream.of(
                Arguments.of(a1, 3, Arrays.copyOfRange(a1, 0, n % 3)),
                Arguments.of(a2, n, Arrays.copyOfRange(a2, 0, 0)),
                Arguments.of(a3, 1, Arrays.copyOfRange(a3, 0, n % 1)),
                Arguments.of(a4, n - 1, Arrays.copyOfRange(a4, 0, n % (n - 1))),
                Arguments.of(a5, n - 2, Arrays.copyOfRange(a5, 0, n % (n - 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void printsCorrectOutput(int[] input, int x, int[] ans) throws InvalidClauseException {
        int t = ans.length;
        String st = "";
        for (int i = 0; i < t; i++)
            st += ans[i] + " ";
        runWithInput(arrayToInput(input) + " " + x, new Clause[]{
                new StringLiteral(st.trim())
        });
    }

    @ParameterizedTest
    @MethodSource("InputProvider")
    void correctRemainderMethod(int[] input, int x, int[] ans) throws Throwable {
        Object[][] arguments = {
                {input, int[].class},
                {x, int.class}
        };
        MethodTest m = new MethodTest(Remainder.class, "remainder", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output,
                "Your remainder method does not return the correct subarray.");

    }
}
