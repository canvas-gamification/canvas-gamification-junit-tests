package temp;

import global.BaseRandomTest;
import global.variables.RandomDouble;
import global.variables.RandomInteger;
import global.variables.Regexable;
import global.variables.StringLiteral;
import global.variables.wrappers.Optional;

public class QuestionExample extends BaseRandomTest {
    public Regexable[] getExpectedOutput() {
        return new Regexable[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 100),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomDouble(6.5, 10.5),
                new Optional(new StringLiteral(". They are the same!"))
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[]{});
    }
}
