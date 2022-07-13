package loops.while_loops.hard.q7;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter a sentence"),
                new NewLine(),
                new StringLiteral("Reversed Sentence: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        RevUp.main(new String[0]);
    }
}
