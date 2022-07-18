package pre_defined_classes.programs_with_changing_behaviour.hard.q9;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Your new position is: "),
                new RandomInteger(48, 58+1, "playerPosition")
        };
    }

    public void runMain() {Monopoly.main(new String[0]);}
}
