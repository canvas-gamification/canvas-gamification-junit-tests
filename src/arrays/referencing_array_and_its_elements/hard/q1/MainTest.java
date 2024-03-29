package arrays.referencing_array_and_its_elements.hard.q1;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
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
        TestOption.defaultInput = arrayToInput(generateAscendingArray(1, n));
        Clause[] c = new Clause[2 * n + 4];
        c[0] = new StringLiteral("Enter 10 numbers:");
        c[1] = new NewLine();
        c[2] = new StringLiteral("The shifted array is:");
        c[3] = new NewLine();
        for (int i = 4; i < 2 * n + 4; i += 2) {
            c[i] = new PlaceHolder();
            c[i + 1] = new StringLiteral(" ");
        }
        return c;
    }

    public void runMain() {
        ALittleToTheRight.main(new String[0]);
    }

    public static int[] shifted(int[] array) {
        int[] ans = array.clone();
        int last = ans[ans.length - 1];
        for (int i = ans.length - 1; i > 0; i--)
            ans[i] = ans[i - 1];
        ans[0] = last;
        return ans;
    }


    static Stream<Arguments> mainInputProvider() {
        int[] a1 = generateRandomArray(-1000, 1000, n);
        int[] a2 = generateRandomArray(-1000000, 1000000, n);
        int[] a3 = generateRandomArray(-100000000, 100000000, n);
        int[] a4 = generateRandomArray(-10, 10, n);
        int[] a5 = replicateArray(0, n);
        int[] a6 = generateAscendingArray(1, n);
        int[] a7 = generateAscendingArray(-n/2, n);
        int[] a8 = generateAscendingArray(-n, n);
        return Stream.of(
                Arguments.of(a1, shifted(a1)),
                Arguments.of(a2, shifted(a2)),
                Arguments.of(a3, shifted(a3)),
                Arguments.of(a4, shifted(a4)),
                Arguments.of(a5, shifted(a5)),
                Arguments.of(a6, shifted(a6)),
                Arguments.of(a7, shifted(a7)),
                Arguments.of(a8, shifted(a8))
        );
    }

    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void printsCorrectOutput(int[] input, int[] ans) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the shifted array.";
        Clause[] c = new Clause[n];
        for (int i = 0; i < n; i++)
            c[i] = new IntegerLiteral(ans[i]);
        runWithInput(arrayToInput(input), c);
    }

    static Stream<Arguments> methodInputProvider() {
        int[] test1 = generateRandomArray(-1000000000, 1000000000, 100000);
        int[] test2 = generateRandomArray(-1000000000, 1000000000, 1000);
        int[] test3 = generateRandomArray(-1000000000, 0, 1000);
        int[] test4 = generateRandomArray(0, 1000000000, 1000);
        int[] test5 = replicateArray(0, 100000);
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33}, new int[]{33, 3, 4, 6, 21, 48, 42, 89, 2, 0, 91}),
                Arguments.of(test1, shifted(test1)),
                Arguments.of(test2, shifted(test2)),
                Arguments.of(test3, shifted(test3)),
                Arguments.of(test4, shifted(test4)),
                Arguments.of(test5, shifted(test5)),
                Arguments.of(new int[]{0, 1}, new int[]{1, 0}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void correctLilToDaRightMethod(int[] input, int[] ans) throws Throwable {
        Object[][] arguments = {
                {input, int[].class}
        };
        MethodTest m = new MethodTest(ALittleToTheRight.class, "lilToDaRight", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output,
                "Your lilToDaRight method does not correctly shift all the array elements one index to the right.");
    }
}
