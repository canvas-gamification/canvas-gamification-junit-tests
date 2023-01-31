package arrays.programs_involving_multidimensional_data.hard.q4;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 3;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(0, 2);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        TicTac.main(new String[0]);
    }
}
