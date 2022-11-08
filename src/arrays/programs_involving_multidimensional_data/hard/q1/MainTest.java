package arrays.programs_involving_multidimensional_data.hard.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 2 4 32 4 2 12 32";
        return new Clause[]{
                new StringLiteral("Enter the number of rows:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the number of columns:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain(){
        Sums.main(new String[0]);
    }
}
