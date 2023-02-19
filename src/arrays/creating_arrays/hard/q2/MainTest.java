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

    final static int num = 10;

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
                Arguments.of(
                        new int[]{0, 1, 1000, 24, 3109, 9, 73821, 73},
                        new int[]{0, 1, 1, 42, 9013, 9, 12837, 37}
                ),
                Arguments.of(
                        new int[]{78},
                        new int[]{87}
                ),
                Arguments.of(
                        new int[]{784, 4389, 573, 481294, 573, 444, 42, 2, 5, 6, 32, 535, 64, 32, 543, 6, 682746, 34, 23, 6, 44, 4, 6643, 2, 7, 542, 53, 7, 2, 3, 543, 52, 543, 52, 524,},
                        new int[]{487, 9834, 375, 492184, 375, 444, 24, 2, 5, 6, 23, 535, 46, 23, 345, 6, 647286, 43, 32, 6, 44, 4, 3466, 2, 7, 245, 35, 7, 2, 3, 345, 25, 345, 25, 425}
                )
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
    void correctReverseMethod(int[] in, int[] ans) throws Throwable {
        Object[][] arguments = {
                {in, int[].class}
        };
        MethodTest m = new MethodTest(RevdArray.class, "reverse", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output, "Your reverse method does not correctly reverse each element in the input integer array.");
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
        c[3] = new StringLiteral("The numbers in the array are:");
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
