package methods.modular_programs.easy.q6;

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
        TestOption.defaultInput = "2012";
        return new Clause[]{
                new StringLiteral("Please enter the year you were born in: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){Century.main(new String[0]);}
}
