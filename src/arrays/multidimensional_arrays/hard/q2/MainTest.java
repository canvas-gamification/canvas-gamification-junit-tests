package arrays.multidimensional_arrays.hard.q2;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3 3 1 2 3 4 5 6 7 8 9";
        return new Clause[]{
                new StringLiteral("Enter the number of rows:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the number of column:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter the values for the array:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("count of even numbers in array = "),
                new IntegerLiteral("even")
        };
    }

    public void runMain(){
        SimpleDisplay.main(new String[0]);
    }
}
