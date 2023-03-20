package arrays.creating_arrays.medium.q7;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomBoolean;

public class MainTest extends BaseTest {
    // Parsons

    private final int n = 100;

    public Clause[] testSentence() {
        Clause[] c = new Clause[n * 2];
        for (int x = 0; x < n * 2; x += 2) {
            c[x] = new RandomBoolean();
            c[x+1] = new NewLine();
        }
        return c;
    }

    public void runMain() {
        RandomBools.main(new String[0]);
    }
}
