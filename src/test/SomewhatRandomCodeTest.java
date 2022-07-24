package test;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;

public class SomewhatRandomCodeTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("This is a test."),
                new NewLine(),
                new RandomInteger(0, 5),
                new NewLine(),
                new RandomChar('A', (char)('A'+18)),
                new NewLine(),
                new RandomDouble(5, 15),
        };
    }

    public void runMain() {
        SomewhatRandomCode.main(new String[0]);
    }
}
