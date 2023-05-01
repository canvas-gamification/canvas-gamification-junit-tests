package arrays.creating_arrays.hard.q2;

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

    final static int num = 500;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(5, 10000, num));
        return clauseBuilder();
    }

    public void runMain() {
        RevdArray.main(new String[0]);
    }

    static Stream<Arguments> reverseInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(1000, 1),
                Arguments.of(758932, 239857),
                Arguments.of(444, 444),
                Arguments.of(85903275, 57230958),
                Arguments.of(24, 42),
                Arguments.of(9010, 109)
        );
    }

    static Stream<int[]> mainMethodInputProvider() {
        return Stream.of(
                ArrayUtil.generateRandomArray(5, 10000, num),
                ArrayUtil.generateRandomArray(5, 10000, num),
                ArrayUtil.generateRandomArray(5, 10000, num),
                ArrayUtil.generateRandomArray(5, 10000, num)
        );
    }

    @ParameterizedTest
    @MethodSource("reverseInputProvider")
    void correctReverseMethod(int in, int ans) throws Throwable {
        Object[][] arguments = {
                {in, int.class}
        };
        MethodTest m = new MethodTest(RevdArray.class, "reverse", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your reverse method does not correctly reverse the provided integer.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(int[] in) {
        int[] ans = solution(in);
        runWithInput(ArrayUtil.arrayToInput(in));

        for (int x = 0; x < in.length; x++) {
            assertEquals(ans[x], Integer.parseInt(getItemByName("num" + x)), "Your program does not correctly print each element in the reversed array.");
        }

    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[num * 2 + 6];

        c[0] = new StringLiteral("Enter " + num + " numbers to add to the array:");
        c[1] = new Optional(new StringLiteral(" "));
        c[2] = new NewLine();
        c[3] = new StringLiteral("The numbers in the reversed array are:");
        c[4] = new Optional(new StringLiteral(" "));
        c[5] = new NewLine();

        int count = 6;

        for (int x = 0; x < num; x++) {
            c[count++] = new IntegerLiteral("num" + x);
            c[count++] = new NewLine();
        }

        return c;
    }

    public static int[] solution(int[] arr) {
        int[] revArr = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            String hold = String.valueOf(arr[x]);
            StringBuilder reversed = new StringBuilder();
            for (int y = hold.length() - 1; y >= 0; y--) {
                reversed.append(hold.charAt(y));
            }
            revArr[x] = Integer.parseInt(String.valueOf(reversed));
        }
        return revArr;
    }
}
