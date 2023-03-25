package arrays.programs_involving_multidimensional_data.medium.q7;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.utils.ArrayUtil.generateRandomArray;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 10;
    public static final int up = 100;
    public static final int down = 1;
    public static final int add = 4;
    public static final int sub = 3;

    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n + 4];
        int t = 0;
        c[t++] = new StringLiteral("Generated array:");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        c[t++] = new StringLiteral("Resulting array:");
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
        MultiDivide.main(new String[0]);
    }

    public static int[][] answerFor(int[][] arr) {
        int[][] ans = arr.clone();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (ans[i][j] % 2 == 0)
                    ans[i][j] += add;
                else
                    ans[i][j] -= sub;
            }
        }
        return ans;
    }


    @Test
    public void printsCorrectOutput() {
        int[][] arr = new int[n][n];
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
                out[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
            }
        }
        CustomAssertions._assertArrayEquals(answerFor(arr), out, "Your program does not correctly add and subtract from the elements of the 2D array.");
    }

    public static int[][] gen(int n) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++)
            ans[i] = generateRandomArray(down, up, n);
        return ans;
    }

    static Stream<int[][]> inputProvider() {
        int[][] t1 = {
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };
        int[][] t2 = {
                {9999, 9999},
                {10000, 10000}
        };
        int[][] t3 = {
                {0, 0},
                {0, 0}
        };
        int[][] t4 = {
                {2}
        };
        int[][] t5 = {
                {3}
        };
        int[][] t6 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1}
        };
        int[][] t7 = gen(50);
        int[][] t8 = gen(50);
        return Stream.of(
                t1, t2, t3, t4, t5, t6, t7, t8
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctAddorSubMethod(int[][] arr) throws Throwable {
        int[][] ans = answerFor(arr);
        Clause[] testSentence = new Clause[ans.length * ans.length + ans.length];
        int t = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++)
                testSentence[t++] = new StringLiteral(ans[i][j] + " ");
            testSentence[t++] = new NewLine();
        }
        Object[][] arguments = {
                {arr, int[][].class}
        };
        MethodTest m = new MethodTest(MultiDivide.class, "addorSub", arguments, testSentence);
        m.setIncorrectMethodStructureErrorMessage("Your addorSub method does not correctly manipulate the elements of the 2D array.");
    }
}
