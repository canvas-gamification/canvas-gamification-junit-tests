package loops.simple_programs_with_repitition.hard.q8;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence(){
        TestOption.isInputTest = true;
        TestOption.defaultInput = "HowCouldThisHappen";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Socially Distanced String: "),
                new PlaceHolder()
        };
    }

    public void runMain(){VirtualSocialDistancing.main(new String[0]);}
}
