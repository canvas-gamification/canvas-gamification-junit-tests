package test.random.general_random_testing;

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
                new NewLine(),
                new RandomInteger(49, 2006),
                new NewLine(),
                new RandomDouble(1.567, 2.5981),
                new NewLine(),
                new RandomDouble(0, 10000),
                new NewLine(),
                new RandomInteger(34, 61)
        };
    }

    public void runMain() {
        SomewhatRandomCode.main(new String[0]);
    }
}
