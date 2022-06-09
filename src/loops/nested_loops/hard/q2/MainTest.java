package loops.nested_loops.hard.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("1 2 3 4 "),
                new NewLine(),
                new StringLiteral("1 2 3 4 "),
                new NewLine(),
                new StringLiteral("1 2 3 4 "),
                new NewLine(),
                new StringLiteral("1 2 3 4 ")
        };
    }

    public void runMain() {
        RepeatTheRepeat.main(new String[0]);
    }
}
