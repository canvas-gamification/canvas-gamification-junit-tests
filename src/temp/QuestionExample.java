package temp;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

public class QuestionExample extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new IntegerLiteral("testInt"),
                new NewLine(),
                new StringLiteral("The prediction by Simon was: "),
                new RandomInteger(0, 10),
                new StringLiteral(", and the number of fingers you held up was: "),
                new RandomInteger(0, 10)
        };
    }

    public void runMain() {
        ProphetRobot.main(new String[0]);
    }

    @Test
    public void testMain() {
        System.err.println(getItemByName("testInt"));
    }
}
