package loops.simple_programs_with_repitition.hard.q6;

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
        TestOption.defaultInput = " Hello Darkness My old friend ";
        return new Clause[]{
                new StringLiteral("Enter a sentence: "),
                new NewLine(),
                new StringLiteral("The new query string is: "),
                new PlaceHolder()
        };
    }

    public void runMain(){QueryStr.main(new String[0]);}
}
