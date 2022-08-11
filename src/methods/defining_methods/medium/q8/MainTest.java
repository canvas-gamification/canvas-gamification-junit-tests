package methods.defining_methods.medium.q8;

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
        TestOption.defaultInput = "4.4 8";
        return new Clause[]{
                new StringLiteral("Please enter the weight of the flour: "),
                new NewLine(),
                new StringLiteral("Please enter the cost: "),
                new NewLine(),
                new StringLiteral("The cost per kg of the flour is: "),
                new DoubleLiteral("total")
        };
    }

    public void runMain(){FlourPower.main(new String[0]);}
}
