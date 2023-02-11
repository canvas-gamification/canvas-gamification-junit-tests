package arrays.programs_involving_multidimensional_data.easy.q8;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 5;
    public static int evenMulti = 5;
    public static int oddMulti = 3;
    public static int top = 1001;

    public Clause[] testSentence() {
        Clause[] c = new Clause[4 * n * n + 2 * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(1, top, i + " " + j);
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
        EvenOrOdd.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() throws InvalidClauseException {
        int[][] arr = new int[n][n];
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(getItemByName(i + " " + j));
                out[i][j] = Integer.parseInt(getItemByName(i + "x" + j));
                if (arr[i][j] % 2 == 0)
                    arr[i][j] *= evenMulti;
                else
                    arr[i][j] *= oddMulti;
            }
        }
        CustomAssertions._assertArrayEquals(arr, out, "Your program does not correctly modify the 2D array.");
    }
}
