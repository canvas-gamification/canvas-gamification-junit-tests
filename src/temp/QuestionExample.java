package temp;

import global.BaseRandomTest;
import global.variables.*;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class QuestionExample extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 10),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomInteger(0, 10)
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[0]);
    }
}
