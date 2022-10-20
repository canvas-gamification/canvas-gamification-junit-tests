package test.random;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;

public class BinCalculationTest extends BaseRandomTest {
    public Clause[] testSentence() {
        Clause[] c = new Clause[400];
        int j = 1;
        for (int i = 0; i < c.length; i++) {
            c[i++] = new RandomInteger(0, j++);
            c[i] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        BinCalculation.main(new String[0]);
    }

}
