package pre_defined_classes.programs_with_changing_behaviour.medium.q3;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("You will find \\$25 in the next "),
                new RandomInteger(0, 4, "choice"),
                new StringLiteral(" days.")
        };
    }

    public void runMain() {
        Realist8Ball.main(new String[0]);
    }
}
