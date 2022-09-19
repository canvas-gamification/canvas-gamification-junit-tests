package arrays.creating_arrays.hard.q4;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Seth \n Liam \n Teresa \n Paige \n Hannah";
        return new Clause[]{
                new StringLiteral("Enter 5 names:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("At index "),
                new IntegerLiteral("index"),
                new StringLiteral(": "),
                new PlaceHolder()
        };
    }

    public void runMain(){
        RandomPickingNames.main(new String[0]);
    }
}
