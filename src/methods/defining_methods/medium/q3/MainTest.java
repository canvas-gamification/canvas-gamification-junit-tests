package methods.defining_methods.medium.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Please enter a sentence: "),
                new NewLine(),
                new StringLiteral("The length of your sentence is: "),
                new IntegerLiteral("length")
        };
    }

    public void runMain(){LengthOfTheString.main(new String[0]);}
}
