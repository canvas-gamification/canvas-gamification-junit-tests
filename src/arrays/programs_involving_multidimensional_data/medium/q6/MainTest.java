package arrays.programs_involving_multidimensional_data.medium.q6;

import global.BaseRandomTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 10;
    public static final int up = 10;
    public static final int down = 1;
    public static final int mul = 10;
    public static final double div = 3.14;

    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
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

    @Test
    public void printsCorrectOutput() {
        int[][] arr = new int[n][n];
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
                arr[i][j] = (int) (arr[i][j] * mul / div);
                out[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
            }
        }
        CustomAssertions._assertArrayEquals(arr, out, "Your program does not correctly manipulate the elements of the 2D array by the specified values.");
    }
}
