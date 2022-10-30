package test.random;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomDouble;
import test.random.RandomDoubleExponent;

public class RandomDoubleExponentTest extends BaseRandomTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new RandomDouble(0, 100000000000000.0),
                new NewLine(),
                new RandomDouble(0, 0.0000000001)
        };
    }

    public void runMain() {
        RandomDoubleExponent.main(new String[0]);
    }
}
