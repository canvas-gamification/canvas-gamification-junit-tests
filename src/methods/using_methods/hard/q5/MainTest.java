package methods.using_methods.hard.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Parsons

    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2";
        return new Clause[]{
                new StringLiteral("Please enter what year you are in university:"),
                new NewLine(),
                new StringLiteral("Your designation is a "),
                new PlaceHolder()
        };
    }

    public void runMain(){Using5.main(new String[0]);}
}
