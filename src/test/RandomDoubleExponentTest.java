package test;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomDouble;

public class RandomDoubleExponentTest extends BaseRandomTest {

    public Clause[] testSentence() {
        return new Clause[]{
                new RandomDouble(0, 100000000000000.0)
        };
    }

    public void runMain() {
        RandomDoubleExponent.main(new String[0]);
    }
}
