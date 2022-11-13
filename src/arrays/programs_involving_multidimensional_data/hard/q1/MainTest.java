package arrays.programs_involving_multidimensional_data.hard.q1;

import global.BaseTest;
import global.MethodTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 2 4 32 4 2 12 32";
        return new Clause[]{
                new StringLiteral("Enter the number of rows:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the number of columns:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Sums.main(new String[0]);
    }

    static Stream<int[][]> mainMethodInputProvider() {
        int[][] a = new int[8][3];

        for (int x = 0; x < 8; x++) {
            a[x] = ArrayUtil.generateRandomArray(1, 11, 3);
        }

        int[][] b = new int[2][2];

        for (int x = 0; x < 2; x++) {
            b[x] = ArrayUtil.generateRandomArray(10, 1001, 2);
        }

        int[][] c = new int[5][10];

        for (int x = 0; x < 5; x++) {
            c[x] = ArrayUtil.generateRandomArray(1, 2, 10);
        }

        int[][] d = new int[15][2];

        for (int x = 0; x < 15; x++) {
            d[x] = ArrayUtil.generateRandomArray(1, 11, 3);
            for (int y = 0; y < 2; y++) {
                d[x][y] *= -1;
            }
        }

        return Stream.of(a, b, c, d);
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
            c[x] = ArrayUtil.generateRandomArray(15, 16, 9);
        }

        int[][] d = new int[17][4];

        for (int x = 0; x < 17; x++) {
            d[x] = ArrayUtil.generateRandomArray(1, 16, 4);
            for (int y = 0; y < 4; y++) {
                d[x][y] *= -1;
            }
        }

        return Stream.of(a, b, c, d);
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void correctMainMethodOutput(int[][] input) throws InvalidClauseException {
        StringBuilder s = new StringBuilder();
        for (int x = 0; x < input.length; x++) {
            s.append(ArrayUtil.arrayToInput(input[x]));
            s.append(" ");
        }
        runWithInput(input.length + " " + input[0].length + " " + s, clauseBuilder(input.length, input[0].length));

        int[] sums = new int[input.length];

        for (int x = 0; x < input.length; x++) {
            for (int y = 0; y < input[0].length; y++) {
                sums[x] += input[x][y];
            }
        }

        for (int x = 0; x < input.length; x++) {
            assertEquals(sums[x], Integer.parseInt(getItemByName(String.valueOf(x))), "Your program does not print the correct sum of rows.");
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

    public Clause[][] clauseBuilder(int rows, int cols) {
        Clause[][] c = new Clause[1][(rows * cols * 3) + (rows * 2)];
        int count = 0;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                c[0][count++] = new StringLiteral("Enter the number for row " + (x + 1) + " column " + (y + 1) + ":");
                c[0][count++] = new Optional(new StringLiteral(" "));
                c[0][count++] = new NewLine();
            }
        }

        for (int x = 0; x < rows; x++) {
            c[0][count++] = new IntegerLiteral(String.valueOf(x));
            c[0][count++] = new StringLiteral(" ");
        }

        return c;
    }
}
