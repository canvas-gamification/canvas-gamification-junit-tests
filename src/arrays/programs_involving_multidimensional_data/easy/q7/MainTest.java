package arrays.programs_involving_multidimensional_data.easy.q7;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 3;
    public static int diff = 30;

    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomDouble(1, 1001, i + " " + j);
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
        ChangedVals.main(new String[0]);
    }

    public static int[][] answerFor(double[][] arr) {
        int[][] ans = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                ans[i][j] = (int) (arr[i][j] + diff);
        }
        return ans;
    }

    @Test
    public void printsCorrectOutput() throws InvalidClauseException {
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Double.parseDouble(getItemByName(i + " " + j));
            }
        }
        int[][] ans = answerFor(arr);
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
            }
        }
        CustomAssertions._assertArrayEquals(ans, out, "Your program does not correctly print the integer 2D array.");
    }
}
