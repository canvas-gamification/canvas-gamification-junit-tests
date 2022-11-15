package test.random;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomDouble;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import test.random.BasicRandomCode;

public class BasicRandomCodeTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("This is a test."),
                new NewLine(),
                new RandomInteger(-1000, -990),
                new NewLine(),
                new RandomInteger(0, 18),
                new NewLine(),
                new RandomInteger(10, 20),
                new NewLine(),
                new RandomInteger(-19, -9),  // TODO: resolve
                new NewLine(),
                new RandomDouble(5, 15),
                new NewLine(),
                new RandomDouble(-15, -5),
        };
    }

    public void runMain() {
        BasicRandomCode.main(new String[0]);
    }
}
