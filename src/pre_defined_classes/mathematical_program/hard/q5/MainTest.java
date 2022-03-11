package pre_defined_classes.mathematical_program.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.*;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The leftHandSide is -0.7760683270883323"),
                new NewLine(),
                new StringLiteral("The rightHandSide is -0.7760683270883322")
        };
    }

    public void runMain() {
        LeftRight.main(new String[]{});
    }
}
