package conditionals.simple_programs_with_decision_points.hard.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Is the door open or closed right now? (Enter true for open and false for closed)"),
                new NewLine(),
                new StringLiteral("")//either I will close the door or Time to open the door
        };
    }

    public void runMain() {
        DoorBoy.main(new String[]{});
    }
}
