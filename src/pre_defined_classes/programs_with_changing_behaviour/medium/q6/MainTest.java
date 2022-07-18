package pre_defined_classes.programs_with_changing_behaviour.medium.q6;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The path you've chosen to go is #"),
                new RandomInteger(0, 4, "chosenPath")
        };
    }

    public void runMain() { ShuffleMovement.main(new String[0]);}
}
