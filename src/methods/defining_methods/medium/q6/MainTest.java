package methods.defining_methods.medium.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "27";
        return new Clause[]{
                new StringLiteral("Please enter the volume of a cube: "),
                new NewLine(),
                new StringLiteral("The side length of the given cube is: "),
                new DoubleLiteral()
        };
    }

    public void runMain(){VolToLength.main(new String[0]);}
}
