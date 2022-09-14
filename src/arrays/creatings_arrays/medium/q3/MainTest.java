package arrays.creatings_arrays.medium.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;

public class MainTest extends BaseTest {
    // Parsons
    private static final int length = 100;

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain() {
        RandomNum.main(new String[0]);
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[length * 2 - 1];
        int count = 0;
        for (int x = 0; x < length - 1; x++) {
            c[count++] = new RandomInteger(0, 10);
            c[count++] = new NewLine();
        }
        c[count] = new RandomInteger(0, 10);
        return c;
    }
}
