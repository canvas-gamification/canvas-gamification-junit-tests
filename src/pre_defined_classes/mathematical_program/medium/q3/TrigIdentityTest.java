package pre_defined_classes.mathematical_program.medium.q3;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

public class TrigIdentityTest extends BaseTest {

    public Clause[] testSentence() {
        return new Clause[]{
            new StringLiteral("The value of sin^2 is: ")
                //Need Double Literal to finish question
        };
    }

    public void runMain() {
        TrigIdentity.main(new String[0]);
    }
}
