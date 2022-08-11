package methods.defining_methods.medium.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "false";
        return new Clause[]{
                new StringLiteral("Enter a boolean: "),
                new NewLine(),
                new StringLiteral("The inverse value of the given boolean variable is: "),
                new PlaceHolder()
        };
    }

    public void runMain(){InverseMethod.main(new String[0]);}
}
