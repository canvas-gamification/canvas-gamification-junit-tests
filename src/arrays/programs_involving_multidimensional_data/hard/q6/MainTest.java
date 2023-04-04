package arrays.programs_involving_multidimensional_data.hard.q6;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 5;
    public static final int m = 5;
    public static final int up = 100;
    public static final int down = 0;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * m + n + 6];
        int t = 0;
        c[t++] = new StringLiteral("Generated array:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[t++] = new RandomInteger(down, up, i + " " + j);
                if (j != n - 1)
                    c[t++] = new StringLiteral(" ");
                else
                    c[t++] = new Optional(new StringLiteral(" "));
            }
            c[t++] = new NewLine();
        }
        c[t++] = new StringLiteral("Maximum value is: ");
        c[t++] = new IntegerLiteral("max");
        c[t] = new Optional(new NewLine());

        return c;
    }

    public void runMain() {
        MaxVal.main(new String[0]);
    }

    @RepeatedTest(10)
    public void printsCorrectOutput() {
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(getItemByName(i + " " + j));
                if (max < a)
                    max = a;
            }
        }
        int out = Integer.parseInt(getItemByName("max"));
        CustomAssertions._assertEquals(max, out, "Your program does not correctly find and print the maximum value of the 2D array.");
    }

    public static int[][] gen(int n, int m){
        int[][] t = new int[n][m];
        for (int i = 0; i < n; i++)
            t[i] = generateRandomArray(down, up, m);
        return  t;
    }

    static Stream<Arguments> inputProvider() {
        int[][] t = gen(10, 15);
        int max = -1;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 15; j++)
                max = Math.max(max, t[i][j]);
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 4, 26, 494, 323},
                                {333, 5, 4, 654, 33},
                                {322, 241, 133, 345, 111}
                        },
                        654
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 4},
                                {3, 2, 1}
                        },
                        5
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        9
                ),
                Arguments.of(
                        new int[][]{
                                {12, 99999, 10, 9},
                                {8, 999, 6, 1},
                                {4, 3, 2, 1}
                        },
                        99999
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9},
                                {10, 11, 12}
                        },
                        12
                ),
                Arguments.of(
                        t, max
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMaxValueMethod(int[][] a, int ans) throws Throwable {
        Object[][] arguments = {
                {a, int[][].class},
        };
        MethodTest m = new MethodTest(MaxVal.class, "maxValue", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your maxValue method does not correctly find the maximum value in a 2D array.");
    }
}
