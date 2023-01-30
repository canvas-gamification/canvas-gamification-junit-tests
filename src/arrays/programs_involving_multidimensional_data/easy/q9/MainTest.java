package arrays.programs_involving_multidimensional_data.easy.q9;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 5;
    public static int div = 5;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + 3 * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(100, 1001, i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        for (int i = 0; i < n; i++) {
            c[t++] = new IntegerLiteral("" + i);
            c[t++] = new StringLiteral(" ");
        }
        return c;
    }

    public void runMain() {
        Sum.main(new String[0]);
    }

    public static int[] answerFor(int[][] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] /= div;
                ans[i] += arr[i][j];
            }
        }
        return ans;
    }

    @Test
    public void printsCorrectOutput() throws InvalidClauseException {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
            }
        }
        int[] ans = answerFor(arr);
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = Integer.parseInt(getItemByName(i + ""));
        }
        CustomAssertions._assertArrayEquals(ans, out, "Your program does not correctly print the sum of each modified row.");
    }
}
