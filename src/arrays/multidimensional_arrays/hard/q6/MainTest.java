package arrays.multidimensional_arrays.hard.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        //format: (first addition attempt) + (second addition attempt)
        Clause[] c = new Clause[(2 + (4 * 7)) + (1)];
        int t = 0;

        int[][][] a = {{{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}}, {{1, 0}, {0, 1}}};
        int[][][] b = {{{4433, 2316, 9879}, {662, 154, 721}, {69, 98, 54}, {1, 4, 3}}, {{65, 43, 12}, {54, 65, 32}, {43, 1, 2}}};
        for (int x = 0; x < a.length; x++) {
            if (a[x].length == b[x].length && a[x][0].length == b[x][0].length) {
                int[][] n = new int[a[x].length][a[x][0].length];
                for (int i = 0; i < n.length; i++)
                    for (int j = 0; j < n[i].length; j++)
                        n[i][j] = a[x][i][j] + b[x][i][j];
                c[t++] = new StringLiteral("The sum of the matrices are:");
                c[t++] = new NewLine();
                for (int[] ints : n) {
                    for (int j = 0; j < n[0].length; j++) {
                        c[t++] = new IntegerLiteral(ints[j]);
                        c[t++] = new StringLiteral(" ");
                    }
                    c[t++] = new NewLine();
                }
            } else
                c[t++] = new StringLiteral("Can't add the arrays because they are different sizes\\!");
        }
        return c;
    }

    public void runMain() {
        OneAndOneMakeTwoDArrays.main(new String[0]);
    }
}
