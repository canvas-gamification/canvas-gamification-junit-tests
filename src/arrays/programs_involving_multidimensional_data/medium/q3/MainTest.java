package arrays.programs_involving_multidimensional_data.medium.q3;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 5;
    public static final int up = 5;
    public static final int down = 1;

    public Clause[] testSentence() {
        Clause[] c = new Clause[6 * n * n + 3 * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + "a" + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + "b" + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new IntegerLiteral(i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        MultiDifferent.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() {
        int[][] out = new int[n][n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.parseInt(getItemByName(i + "a" + j)) * Integer.parseInt(getItemByName(i + "b" + j));
                out[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        CustomAssertions._assertArrayEquals(ans, out, "Your program does not correctly multiply elements of the two 2D arrays.");
    }

    static Stream<Arguments> inputProvider() {
        int[][] t1 = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {3, 4, 5, 1, 2},
                {4, 5, 1, 2, 3},
                {5, 1, 2, 3, 4}
        };
        int[][] t2 = {
                {1, 4, 9, 16, 25},
                {4, 9, 16, 25, 1},
                {9, 16, 25, 1, 4},
                {16, 25, 1, 4, 9},
                {25, 1, 4, 9, 16},
        };
        int[][] t3 = {
                {1, 0},
                {0, 1}
        };
        int[][] t4 = {
                {0, 1},
                {1, 0}
        };
        int[][] t5 = {
                {0, 0},
                {0, 0}
        };
        int[][] t6 = {
                {2}
        };
        int[][] t7 = {
                {4}
        };
        return Stream.of(
                Arguments.of(t1, t1, t2),
                Arguments.of(t3, t4, t5),
                Arguments.of(t6, t6, t7)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctAddMatrices(int[][] a, int[][] b, int[][] ans) throws Throwable {
        TestOption.incorrectStructureErrorMessage = "Your multiply method does not correctly multiply elements of the two 2D arrays.";
        Clause[] c = new Clause[ans.length * ans.length + ans.length];
        int t = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++)
                c[t++] = new StringLiteral("" + ans[i][j] + " ");
            c[t++] = new NewLine();
        }
        Object[][] arguments = {
                {a, int[][].class},
                {b, int[][].class}
        };
        MethodTest m = new MethodTest(MultiDifferent.class, "multiply", arguments, c);
    }
}
