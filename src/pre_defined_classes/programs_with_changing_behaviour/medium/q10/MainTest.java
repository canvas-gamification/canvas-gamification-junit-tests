package pre_defined_classes.programs_with_changing_behaviour.medium.q10;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Player 1 won "),
                new RandomInteger(0, 4, "timesPlay1Won"),
                new StringLiteral(" out of the 3 rounds")
        };
    }

    public void runMain() {HeadsTails.main(new String[0]);}
}
