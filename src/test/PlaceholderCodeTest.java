package test;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.PlaceHolder;

public class PlaceholderCodeTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new PlaceHolder()
        };
    }

    public void runMain() {
        PlaceholderCode.main(new String[0]);
    }
}
