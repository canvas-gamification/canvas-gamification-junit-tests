package methods.modular_programs.easy.q4;

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
        TestOption.defaultInput = "345.32 1.2345 2.3";
        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new StringLiteral("Enter the third number: "),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the first variable are "),
                new DoubleLiteral("first"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the second variable are "),
                new DoubleLiteral("second"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the third variable are "),
                new DoubleLiteral("third")
        };
    }

    public void runMain(){ReturnChange.main(new String[0]);}
}
