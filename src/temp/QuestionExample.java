package temp;

import global.BaseRandomTest;
import global.variables.*;
import global.variables.wrappers.*;

public class QuestionExample extends BaseRandomTest {

    // TODO: Step 1. Running main()
    // TODO: Step 2. Initializing regex "sentence"
    // TODO: Step 3.

    // Step 2 - Technique 1
    public Regexable[] getExpectedOutput() {
        return new Regexable[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 10),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomInteger(0, 10),
                new Optional(new StringLiteral(". They are the same!"))
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[]{});
    }
}
