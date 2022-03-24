package conditionals.simple_programs_with_decision_points.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Is the door open or closed right now? (Enter true for open and false for closed)"),
                new NewLine(),
                new Optional(new StringLiteral("I will close the door")),
                new Optional(new StringLiteral("Time to open the door"))
        };
    }

    public void runMain() {
        DoorBoy.main(new String[]{});
    }
}
