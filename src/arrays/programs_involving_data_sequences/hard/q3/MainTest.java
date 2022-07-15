package arrays.programs_involving_data_sequences.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "a p p l e i s b a d 0 4";
        return new Clause[]{
                new StringLiteral("Enter the character array:"),
                new NewLine(),
                new StringLiteral("Enter the starting index:"),
                new NewLine(),
                new StringLiteral("Enter the ending index:"),
                new NewLine(),
                new StringLiteral("Your string is:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SubThat.main(new String[0]);
    }
}
