package temp;

import global.BaseRandomTest;
import global.variables.RandomDouble;
import global.variables.RandomInteger;
import global.variables.Clause;
import global.variables.StringLiteral;
import global.variables.wrappers.Optional;

public class QuestionExample extends BaseRandomTest {
    public Clause[] getExpectedOutput() {
        return new Clause[]{
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
