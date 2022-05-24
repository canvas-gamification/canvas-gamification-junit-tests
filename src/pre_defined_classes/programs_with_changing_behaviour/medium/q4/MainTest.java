package pre_defined_classes.programs_with_changing_behaviour.medium.q4;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Player One's hand sign is: "),
                new RandomInteger(1, 4, "personOne"),
                new NewLine(),
                new StringLiteral("Player Two's hand sign is: "),
                new RandomInteger(1, 4, "personTwo"),
        };
    }

    public void runMain() {
        RockPaperScissors.main(new String[0]);
    }
}
