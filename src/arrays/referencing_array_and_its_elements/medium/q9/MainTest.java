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

    public static final int n = 150;

    public Clause[] testSentence() {
        Clause[] c = new Clause[2 * n + 2 * ((n + 1)/2) + 7];
        int t = 0;
        c[t++] = new StringLiteral("The random generated array:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        for (int i = 0; i < n - 1; i++) {
            c[t++] = new RandomInteger(1, 1001, "" + i);
            c[t++] = new StringLiteral(" ");
        }
        c[t++] = new RandomInteger(1, 1001, "" + (n - 1));
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        c[t++] = new StringLiteral("The elements on even indices are:");
        c[t++] = new Optional(new StringLiteral(" "));
        c[t++] = new NewLine();
        for (int i = 0; i < (n + 1)/ 2 - 1; i++) {
            c[t++] = new RandomInteger(1, 1001, "S" + i);
            c[t++] = new StringLiteral(" ");
        }
        c[t++] = new RandomInteger(1, 1001, "S" + ((n+1) / 2 - 1));
        c[t] = new Optional(new StringLiteral(" "));
        return c;
    }

    public void runMain() {
        EveryEven.main(new String[0]);
    }

    @Test
    void printsCorrectOutput() {
        runMain();
        int[] a = new int[n];
        int[] b = new int[(n +1)/ 2];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(getItemByName("" + i));
        for (int i = 0; i < (n +  1)/ 2; i++)
            b[i] = Integer.parseInt(getItemByName("S" + i));
        boolean flg = true;
        for (int i = 0; i < n; i += 2) {
            if (a[i] != b[i / 2])
                flg = false;
        }
        assertTrue(flg, "Your program does not correctly print the even elements of the array.");
    }
}
