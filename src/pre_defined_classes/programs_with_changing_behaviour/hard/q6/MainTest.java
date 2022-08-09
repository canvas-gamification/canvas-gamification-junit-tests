package pre_defined_classes.programs_with_changing_behaviour.hard.q6;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Congratulations Student Number : "),
                new RandomInteger(10000000, 99999999, "stuNum"),
                new StringLiteral("! You win!")
        };
    }

    public void runMain() {Draw.main(new String[0]);}
}
