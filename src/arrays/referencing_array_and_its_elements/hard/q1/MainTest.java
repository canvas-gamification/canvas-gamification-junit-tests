package arrays.referencing_array_and_its_elements.hard.q1;

import arrays.programs_involving_data_sequences.medium.q5.DoTheDeletion;
import global.BaseTest;
import global.MethodTest;
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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class MainTest extends BaseTest {
    // Java

    public static int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1 2 3 4 5 6 7 8 9 10";
        Clause[] c = new Clause[2 * n + 4];
        c[0] = new StringLiteral("Enter 10 numbers:");
        c[1] = new NewLine();
        c[2] = new StringLiteral("The shifted array is:");
        c[3] =  new NewLine();
        for(int i = 4; i < 2 * n + 4; i += 2){
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
        int[] a2 = generateRandomArray(-1000, 1000, n);
        int[] a3 = generateRandomArray(-1000, 1000, n);
        int[] a4 = generateRandomArray(-1000, 1000, n);
        return Stream.of(
                Arguments.of(a1, shifted(a1)),
                Arguments.of(a2, shifted(a2)),
                Arguments.of(a3, shifted(a3)),
                Arguments.of(a4, shifted(a4))

        );
    }
    @ParameterizedTest
    @MethodSource("mainInputProvider")
    void correctMainMethod(int[] input, int[] ans) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your program did printed the correct shifted array in the main method";
        Clause[] c = new Clause[n];
        for(int i = 0; i < n; i ++)
            c[i] = new IntegerLiteral(ans[i]);
        runWithInput(arrayToInput(input), c);
    }

    static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33}, new int[]{33, 3, 4, 6, 21, 48, 42, 89, 2, 0, 91}),
                Arguments.of(new int[]{0, 1}, new int[]{1, 0}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0})

        );
    }
    @ParameterizedTest
    @MethodSource("methodInputProvider")
    void LilToDaRightMethodTest(int[] input, int[] ans) throws Throwable {
        Object[][] arguments = {
                {input, int[].class}
        };
        MethodTest m = new MethodTest(ALittleToTheRight.class, "lilToDaRight", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output,
                "Your lilToDaRight does not shift the array correctly");
    }
}
