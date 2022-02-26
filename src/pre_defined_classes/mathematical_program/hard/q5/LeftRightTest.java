package pre_defined_classes.mathematical_program.hard.q5;

import global.BaseTest;
import global.variables.Clause;
import global.variables.NewLine;
import global.variables.RandomInteger;
import global.variables.StringLiteral;
import global.variables.wrappers.Optional;
import temp.Example;

public class LeftRightTest extends BaseTest {
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
