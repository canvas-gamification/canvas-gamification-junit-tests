package arrays.programs_involving_multidimensional_data.easy.q4;

import global.BaseRandomTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 4;
    public static int up = 100;
    public static int down = 0;
    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n + 4];
        int p = 0;
        c[p ++] = new StringLiteral("Before the rotation:");
        c[p ++] = new NewLine();
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                c[p ++] = new RandomInteger(down, up, i + " " + j);
                c[p ++] = new StringLiteral(" ");
            }
            c[p ++] = new NewLine();
        }

        c[p++] = new StringLiteral("After the rotation:");
        c[p++] = new NewLine();
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                c[p ++] = new IntegerLiteral(i + "x" + j);
                c[p ++] = new StringLiteral(" ");
            }
            c[p ++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        Rotation.main(new String[0]);
    }

    public static int[][] answerFor(int[][] arr) {
        int sz = arr.length;
        int a = arr[0][0], b = arr[0][sz - 1], c = arr[sz - 1][sz - 1], d = arr[sz - 1][0];
        arr[0][sz - 1] = a;
        arr[sz - 1][sz - 1] = b;
        arr[sz - 1][0] = c;
        arr[0][0] = d;
        return arr;
    }

    @Test
    public void printsCorrectOutput(){
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        int[][] ans = answerFor(arr);
        int[][] in = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++)
                in[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
        }
        CustomAssertions._assertArrayEquals(ans, in, "Your program does not rotate the 2D array correctly.");
    }
    static Stream<int[][]> inputProvider() {
        int[][] t1 = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };
        int[][] t2 = {
                {1, 0},
                {0, 1}
        };
        int[][] t3 = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {3, 4, 5, 1, 2},
                {4, 5, 1, 2, 3},
                {5, 1, 2, 3, 4}
        };
        int[][] t4 = {
                {1, 0, 0, 2},
                {0, 0 ,0 ,0},
                {0, 0, 0, 0},
                {4, 0, 0, 3}
        };
        return Stream.of(
            t1, t2, t3, t4
        );
    }
    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctRotateArrayMethod(int[][] arr) throws Throwable {
        int[][] ans = answerFor(arr);
        Clause[] c = new Clause[2 * arr.length * arr.length + arr.length];
        int t = 0;
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr.length; j ++){
                c[t ++] = new StringLiteral("" + ans[i][j]);
                c[t ++] = new StringLiteral(" ");
            }
            c[t ++] = new NewLine();
        }
        Object[][] arguments = {
                {arr, int[][].class}
        };
        TestOption.incorrectStructureErrorMessage = "Your rotateArray method does not rotate the 2D array correctly.";
        MethodTest m = new MethodTest(Rotation.class, "rotateArray", arguments, c);
    }
}
