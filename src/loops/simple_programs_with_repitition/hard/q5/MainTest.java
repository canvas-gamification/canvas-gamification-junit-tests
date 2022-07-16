package loops.simple_programs_with_repitition.hard.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){ NowThatsPerfect.main(new String[0]); }
}
