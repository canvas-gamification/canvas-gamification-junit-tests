package methods.defining_methods.medium.q4;

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
        TestOption.defaultInput = "2022 1998";
        return new Clause[]{
                new StringLiteral("Please enter the height of the cylinder: "),
                new NewLine(),
                new StringLiteral("Please enter the radius of the cylinder: "),
                new NewLine(),
                new StringLiteral("The volume of the given cylinder is: "),
                new DoubleLiteral("volume")
        };
    }

    public void runMain(){CylinderTime.main(new String[0]);}
}
