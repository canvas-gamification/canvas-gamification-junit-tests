package arrays.programs_involving_multidimensional_data.medium.q8;

import global.BaseRandomTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors

    public static final int n = 10;
    public static final int up = 1000;
    public static final int down = 1;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * n + n + 2];
        int t = 0;
        c[t++] = new RandomInteger(down, up + 1, "num");
        c[t++] = new NewLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[t++] = new DoubleLiteral(i + " " + j);
                c[t++] = new StringLiteral(" ");
            }
            c[t++] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        IdenticalGen.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() {
        double num = Math.sqrt(Double.parseDouble(getItemByName("num")));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                CustomAssertions._assertEquals(num, Double.parseDouble(getItemByName(i + " " + j)), "Your program does not print the correct 2D array containing the sqrt of the generated number.");
            }
        }
    }
}
