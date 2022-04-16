package conditionals.simple_programs_with_decision_points.hard.q4;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "true";

        return new Clause[]{
                new StringLiteral("Is the door open or closed right now\\? \\(Enter true for open and false for closed\\)"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        DoorBoy.main(new String[0]);
    }

    @Test
    public void testOpen() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program should have closed the door, it was already open.";
        runWithInput(String.valueOf(true), new Clause[]{
                new StringLiteral("I will close the door")
        });
    }

    @Test
    public void testClosed() throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program should have opened the door, it was already closed.";
        runWithInput(String.valueOf(false), new Clause[]{
                new StringLiteral("Time to open the door")
        });
    }
}
