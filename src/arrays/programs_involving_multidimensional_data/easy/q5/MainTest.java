package arrays.programs_involving_multidimensional_data.easy.q5;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;

public class MainTest extends BaseRandomTest {
    // Parsons

    public static int n = 5;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new RandomInteger(1, 1000);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        ValueLock.main(new String[0]);
    }
}
