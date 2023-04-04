package arrays.arrays_with_methods.hard.q12;

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
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    static final int n = 10;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(1, 10000, n));
        return clauseBuilder();
    }

    public void runMain() {
        ArrayOfMultiples.main(new String[0]);
    }

    static Stream<int[]> mainMethodInputProvider(){
        return Stream.of(
                ArrayUtil.generateAscendingArray(1, n),
                ArrayUtil.generateAscendingArray(-100, n, 5),
                ArrayUtil.generateRandomArray(0, 10000, n),
                ArrayUtil.generateRandomArray(-10000, 10000, n),
                ArrayUtil.generateRandomArray(0, 5, n)
        );
    }

    static Stream<int[]> multiplyElementsInputProvider(){
        return Stream.of(
                ArrayUtil.generateAscendingArray(1, n),
                ArrayUtil.generateAscendingArray(-100, n, 5),
                ArrayUtil.generateRandomArray(0, 10000, n),
                ArrayUtil.generateRandomArray(-10000, 10000, n),
                ArrayUtil.generateRandomArray(0, 5, n),
                ArrayUtil.generateRandomArray(1, 100, 525),
                new int[]{0, 1, 0, 1000, 0, 60, 0, 1327894267},
                new int[]{77, -11, 23, 5, 7322, 654, 54},
                new int[]{1},
                new int[]{},
                new int[]{2, 3290},
                new int[]{-4738, -43, -64, -8124, -1, -43, -7, -237, -53}
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyElementsInputProvider")
    void correctMultiplyElementsMethod(int[] in) throws Throwable {
        int[] expected = solution(in);
        Object[][] arguments = {
                {in, int[].class}
        };
        MethodTest m = new MethodTest(ArrayOfMultiples.class, "multiplyElements", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(expected, output, "Your multiplyElements method does not return the correct array of multiplied elements.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int[] arr) {
        int[] expected = solution(arr);
        runWithInput(ArrayUtil.arrayToInput(arr));

        for (int x = 0; x < arr.length; x++) {
            assertEquals(expected[x], Integer.parseInt(getItemByName("num" + x)), "Your program does not correctly print each element in the multiplied array.");
        }
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[n * 2 + 6];

        c[0] = new StringLiteral("Enter an array of " + n + " integers:");
        c[1] = new Optional(new StringLiteral(" "));
        c[2] = new NewLine();
        c[3] = new StringLiteral("The multiplied elements are:");
        c[4] = new Optional(new StringLiteral(" "));
        c[5] = new NewLine();

        int count = 6;

        for (int x = 0; x < n-1; x++) {
            c[count++] = new IntegerLiteral("num" + x);
            c[count++] = new StringLiteral(" ");
        }
        c[count++] = new IntegerLiteral("num"+ (n-1));
        c[count] = new Optional(new StringLiteral(" "));

        return c;
    }

    private static int[] solution(int[] arr) {
        int[] res = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            if (x == 0) {
                res[0] = arr[0] * arr[arr.length - 1];
            } else {
                res[x] = arr[x] * arr[x - 1];
            }
        }
        return res;
    }
}
