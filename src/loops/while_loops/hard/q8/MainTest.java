package loops.while_loops.hard.q8;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("")
        };
    }

    public void runMain() {CounterChar.main(new String[0]);}
}
