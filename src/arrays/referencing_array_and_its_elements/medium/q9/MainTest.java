package arrays.referencing_array_and_its_elements.medium.q9;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseRandomTest {
    // Java

    public static final int n = 10;

    public Clause[] testSentence() {
        Clause[] c = new Clause[3 * n + 5];
        c[0] = new StringLiteral("The random generated array:");
        c[1] = new NewLine();
        for (int i = 2; i < 2 * n; i += 2) {
            c[i] = new RandomInteger(1, 1001, "" + ((i - 2) / 2));
            c[i + 1] = new StringLiteral(" ");
        }
        c[2 * n] = new RandomInteger(1, 1001, "" + (n - 1));
        c[2 * n + 1] = new Optional(new StringLiteral(" "));
        c[2 * n + 2] = new NewLine();
        c[2 * n + 3] = new StringLiteral("The elements on even indices are:");
        c[2 * n + 4] = new NewLine();
        for (int i = 2 * n + 5; i < 3 * n + 3; i += 2) {
            c[i] = new RandomInteger(1, 1001, "S" + (((i - 5) / 2) - n));
            c[i + 1] = new StringLiteral(" ");
        }
        c[3 * n + 3] = new RandomInteger(1, 1001, "S" + (n / 2 - 1));
        c[3 * n + 4] = new Optional(new StringLiteral(" "));
        return c;
    }

    public void runMain() {
        EveryEven.main(new String[0]);
    }

    @Test
    void printsCorrectOutput() {
        runMain();
        int[] a = new int[n];
        int[] b = new int[n / 2];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(getItemByName("" + i));
        for (int i = 0; i < n / 2; i++)
            b[i] = Integer.parseInt(getItemByName("S" + i));
        boolean flg = true;
        for (int i = 0; i < n; i += 2) {
            if (a[i] != b[i / 2])
                flg = false;
        }
        assertTrue(flg);

    }
}