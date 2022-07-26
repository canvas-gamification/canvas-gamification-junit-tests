package pre_defined_classes.programs_with_changing_behaviour.medium.q7;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The response you should pick is #"),
                new RandomInteger(0, 5, "MCQChoice")
        };
    }

    public void runMain() {ShuffleChoices.main(new String[0]);}
}
