package pre_defined_classes.programs_with_changing_behaviour.medium.q2;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("For this action, you rolled: "),
                new RandomInteger(1, 21, "d20")
        };
    }

    public void runMain() {
        DnDRandom.main(new String[0]);
    }
}
