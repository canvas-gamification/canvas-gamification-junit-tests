package pre_defined_classes.programs_with_changing_behaviour.hard.q10;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomInteger;
import global.variables.clauses.StringLiteral;

public class MainTest  extends BaseRandomTest {
    // Parsons with Distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The first paper is: "),
                new RandomInteger(0, 20, "firstPaper"),
                new NewLine(),
                new StringLiteral("The second paper is: "),
                new RandomInteger(0, 20, "secondPaper"),
                new NewLine(),
                new StringLiteral("The third paper is: "),
                new RandomInteger(0, 20, "thirdPaper"),
                new NewLine()
        };
    }

    public void runMain() {
        ProphetBot.main(new String[0]);
    }
}
