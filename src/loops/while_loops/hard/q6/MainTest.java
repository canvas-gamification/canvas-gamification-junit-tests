package loops.while_loops.hard.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral("number"),
                new StringLiteral("! = "),
                new IntegerLiteral("factorial")
        };
    }

    public void runMain() { FactOrIal.main(new String[0]); }
}
