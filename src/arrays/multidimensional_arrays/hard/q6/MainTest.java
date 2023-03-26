package arrays.multidimensional_arrays.hard.q6;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons

    public static final int[][] a = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}};
    public static final int[][] b = {{4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54}, {1, 4, 3}};

    public Clause[] testSentence() {
        if (a.length != b.length || a[0].length != b[0].length) {
            return new Clause[]{
                    new StringLiteral("Can't add the arrays because they are different sizes!")
            };
        } else {
            Clause[] c = new Clause[2 * a.length + 2];
            int[][] ans = answerFor(a, b);
            int t = 0;
            c[t++] = new StringLiteral("The sum of the matrices are:");
            c[t++] = new NewLine();
            for (int i = 0; i < a.length; i++) {
                String st = "";
                for (int j = 0; j < a[0].length; j++) {
                    st += ans[i][j] + " ";
                }
                c[t++] = new StringLiteral(st);
                c[t++] = new NewLine();
            }
            return c;
        }
    }

    public void runMain() {
        OneAndOneMakeTwoDArrays.main(new String[0]);
    }

    public static int[][] answerFor(int[][] x, int[][] y) {
        if (x.length != y.length || x[0].length != y[0].length)
            return null;
        int[][] ans = new int[x.length][x[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++)
                ans[i][j] = x[i][j] + y[i][j];
        }
        return ans;
    }

    static Stream<Arguments> inputProvider() {
        int[][] t1 = {
                {12, 54, 31},
                {54, 76, 32},
                {23, 32, 12}
        };
        int[][] t2 = {
                {65, 43, 12},
                {54, 65, 32},
                {43, 1, 2}
        };
        int[][] t3 = {
                {1, 0},
                {0, 1}
        };
        int[][] t4 = {
                {0, 1},
                {1, 0}
        };
        return Stream.of(
                Arguments.of(t1, t2),
                Arguments.of(t3, t4),
                Arguments.of(t1, t3),
                Arguments.of(t2, t4)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctAddMatrices(int[][] a, int[][] b) throws Throwable {
        Object[][] arguments = {
                {a, int[][].class},
                {b, int[][].class}
        };
        MethodTest m = new MethodTest(OneAndOneMakeTwoDArrays.class, "addMatrices", arguments);
        Object output = m.callMethod();
        int[][] ans = answerFor(a, b);
        if (ans != null)
            CustomAssertions._assertArrayEquals(ans, output, "Your addMatrices method does not correctly add two matrices.");
        else
            assertTrue(output == null, "Your addMatrices method does not correctly identify invalid input.");
    }
}
