package arrays.creating_arrays.medium.q6;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    private static final int length = 100;

    public Clause[] testSentence() {
        return clauseBuilder();
    }

    public void runMain(){
        TrueBools.main(new String[0]);
    }

    public Clause[] clauseBuilder() {
        Clause[] c = new Clause[length * 2 - 1];
        int count = 0;
        for (int x = 0; x < length - 1; x++) {
            c[count++] = new StringLiteral("true");
            c[count++] = new NewLine();
        }
        c[count] = new StringLiteral("true");
        return c;
    }
}
