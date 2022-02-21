package temp;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class QuestionExample extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral(1000, 200),
                new NewLine(),
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 10),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomInteger(0, 10)
        };
    }

    public void runMain() {
        provideInput("1");
        ProphetRobot.main(new String[0]);
    }
}
