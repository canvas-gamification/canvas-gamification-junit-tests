package arrays.creating_arrays.hard.q3;

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
        TestOption.defaultInput = "34 1 5432 765 -12";
        return new Clause[]{
                new StringLiteral("Enter 5 integers:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new IntegerLiteral("one"),
                new NewLine(),
                new IntegerLiteral("two"),
                new NewLine(),
                new IntegerLiteral("three"),
                new NewLine(),
                new IntegerLiteral("four"),
                new NewLine(),
                new IntegerLiteral("five")
        };
    }

    public void runMain(){
        StoringInts.main(new String[0]);
    }
}
