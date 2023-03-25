package arrays.programs_involving_multidimensional_data.hard.q1;

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

    final static int size = 4;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = ArrayUtil.arrayToInput(ArrayUtil.generateRandomArray(1, 11, size * size));
        return clauseBuilder();
    }

    public void runMain() {
        Sums.main(new String[0]);
    }

    static Stream<int[][]> mainMethodInputProvider() {
        int[][] a = new int[size][size];
        for (int x = 0; x < size; x++) {
            a[x] = ArrayUtil.generateRandomArray(1, 11, size);
        }

        int[][] b = new int[size][size];
        for (int x = 0; x < size; x++) {
            b[x] = ArrayUtil.generateRandomArray(10, 1001, size);
        }

        int[][] c = new int[size][size];
        for (int x = 0; x < size; x++) {
            c[x] = ArrayUtil.replicateArray(2, size);
        }

        int[][] d = new int[size][size];
        for (int x = 0; x < size; x++) {
            d[x] = ArrayUtil.generateRandomArray(1, 11, size);
            for (int y = 0; y < size; y++) {
                d[x][y] *= -1;
            }
        }

        int[][] e = new int[size][size];
        for (int x = 0; x < size; x++) {
            e[x] = ArrayUtil.generateAscendingArray(1, size, 3);
        }

        return Stream.of(a, b, c, d, e);
    }

    static Stream<int[][]> sumsInputProvider() {
        int[][] a = new int[7][3];
        for (int x = 0; x < 7; x++) {
            a[x] = ArrayUtil.generateRandomArray(0, 21, 3);
        }

        int[][] b = new int[4][4];
        for (int x = 0; x < 4; x++) {
            b[x] = ArrayUtil.generateRandomArray(1, 100001, 4);
        }

        int[][] c = new int[2][9];
        for (int x = 0; x < 2; x++) {
            c[x] = ArrayUtil.replicateArray(15, 9);
        }

        int[][] d = new int[17][4];
        for (int x = 0; x < 17; x++) {
            d[x] = ArrayUtil.generateRandomArray(1, 16, 4);
            for (int y = 0; y < 4; y++) {
                d[x][y] *= -1;
            }
        }

        int[][] e = new int[26][43];
        for (int x = 0; x < 26; x++) {
            e[x] = ArrayUtil.generateAscendingArray(1, 43, 5);
        }

        return Stream.of(a, b, c, d, e);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int[][] input) {
        StringBuilder s = new StringBuilder();
        for (int[] ints : input) {
            s.append(ArrayUtil.arrayToInput(ints));
            s.append(" ");
        }
        runWithInput(s.toString());

        int[] sums = new int[size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                sums[x] += input[x][y];
            }
        }

        for (int x = 0; x < size; x++) {
            assertEquals(sums[x], Integer.parseInt(getItemByName(String.valueOf(x))), "Your program does not print the correct sum of the elements in each row of the array.");
        }
    }

    @ParameterizedTest
    @MethodSource("sumsInputProvider")
    void correctSumsMethod(int[][] a) throws Throwable {
        Object[][] arguments = {
                {a, int[][].class}
        };
        MethodTest m = new MethodTest(Sums.class, "sums", arguments);
        Object output = m.callMethod();

        int[] sums = new int[a.length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                sums[i] += a[i][j];

        CustomAssertions._assertArrayEquals(sums, output, "Your sums method does not correctly calculate the sum of each row.");
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[size * 3 + size * 2];
        int count = 0;

        for (int x = 0; x < size; x++) {
            c[count++] = new StringLiteral("Enter " + size + " numbers for row " + (x + 1) + ":");
            c[count++] = new Optional(new StringLiteral(" "));
            c[count++] = new NewLine();
        }

        for (int x = 0; x < size; x++) {
            c[count++] = new IntegerLiteral(String.valueOf(x));
            c[count++] = new StringLiteral(" ");
        }

        return c;
    }
}
