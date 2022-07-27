package pre_defined_classes.programs_with_changing_behaviour.medium.q1;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 11, "prediction"),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomInteger(0, 11, "fingers")
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[0]);
    }
}
