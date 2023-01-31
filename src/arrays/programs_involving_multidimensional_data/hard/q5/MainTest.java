package arrays.programs_involving_multidimensional_data.hard.q5;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 2;
    public static final int m = 13;
    public static final int down = 97;
    public static final int up = 122;


    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n * m + n + n * m + n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[t++] = new RandomInteger(down, up + 1, i + " " + j);
                if (j != m - 1)
                    c[t++] = new StringLiteral(" ");
                else
                    c[t++] = new Optional(new StringLiteral(" "));
            }
            if (i != n - 1)
                c[t++] = new NewLine();
            else
                c[t++] = new Optional(new NewLine());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                c[t++] = new RandomChar((char) down, (char) (up + 1), i + "c" + j);
            if (i != n - 1)
                c[t++] = new NewLine();
            else
                c[t++] = new Optional(new NewLine());
        }
        return c;
    }

    public void runMain() {
        ChartoInt.main(new String[0]);
    }

    @Test
    public void printsCorrectOutput() throws InvalidClauseException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                CustomAssertions._assertEquals(((char) Integer.parseInt(getItemByName(i + " " + j))) + "", getItemByName(i + "c" + j)
                        , "Your program does not correctly change the integer 2D array to a char 2D array.");
            }
        }

    }
}
