package test;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;

public class SomewhatRandomCodeTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("This is a test."),
                new NewLine(),
//                new RandomDouble(0, 1251689519848456516516654645.25),
//                new NewLine(),
                new RandomDouble(0, 12/10000000000000000054895562.36),
        };
    }

    public void runMain() {
        SomewhatRandomCode.main(new String[0]);
    }
}
