package pre_defined_classes.programs_with_changing_behaviour.hard.q5;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("You've decided to burn Song #"),
                new RandomInteger(0, 4, "songChoice"),
                new StringLiteral(", and you're making "),
                new RandomInteger(25000, 250000, "discNumber"),
                new StringLiteral("CDs")
        };
    }

    public void runMain() {
        ShuffleTime.main(new String[0]);
    }
}
