package arrays.programs_involving_multidimensional_data.hard.q7;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 5;
    public static final int upperBound = 100;
    public static final int lowerBound = 0;

    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n + 4];
        int t = 0;
        c[t++] = new StringLiteral("The random 2D array:");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomDouble(lowerBound, upperBound + 1, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        c[t++] = new StringLiteral("The rounded 2D array:");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new IntegerLiteral(i + "x" + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        Rounding.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() {
        int[][] ans = new int[n][n];
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (int) Math.round(Double.parseDouble(getItemByName(i + " " + j)));
                out[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
            }
        }
        CustomAssertions._assertArrayEquals(ans, out, "Your program does not correctly round and print the grades in the 2D array.");
    }

    static Stream<Arguments> inputProvider() {
        double[][] t1 = {
                {1.5, 2.4, 3.3, 4.2, 5.1},
                {2.4, 3.3, 4.2, 5.1, 1.5},
                {3.3, 4.2, 5.1, 1.5, 2.4},
                {4.2, 5.1, 1.5, 2.4, 3.3},
                {5.1, 1.5, 2.4, 3.3, 4.2}
        };
        int[][] a1 = {
                {2, 2, 3, 4, 5},
                {2, 3, 4, 5, 2},
                {3, 4, 5, 2, 2},
                {4, 5, 2, 2, 3},
                {5, 2, 2, 3, 4}
        };
        double[][] t2 = {
                {1.0, 0.5},
                {0.5, 1.0}
        };
        int[][] a2 = {
                {1, 1},
                {1, 1}
        };
        double[][] t3 = {
                {0.1, 0.2},
                {0.3, 0.4}
        };
        int[][] a3 = {
                {0, 0},
                {0, 0}
        };
        double[][] t4 = {
                {2.5}
        };
        int[][] a4 = {
                {3}
        };

        return Stream.of(
                Arguments.of(t1, a1),
                Arguments.of(t2, a2),
                Arguments.of(t3, a3),
                Arguments.of(t4, a4)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctRoundingMethod(double[][] arr, int[][] ans) throws Throwable {
        Object[][] arguments = {
                {arr, double[][].class}
        };
        MethodTest m = new MethodTest(Rounding.class, "rounding", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertArrayEquals(ans, output, "Your rounding method does not return the correct 2D array containing rounded grades.");
    }
}
