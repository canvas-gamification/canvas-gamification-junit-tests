package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q6;

import global.BaseRandomTest;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "0";
        return new Clause[]{
                new StringLiteral("Are computers smarter than humans\\? \\(0 for no, 1 for yes\\)\\: "),
                new NewLine(),
                new PlaceHolder(),
                new StringLiteral("You are "),
                new RandomInteger(1, 100),
                new StringLiteral(" percent correct")
        };
    }

    public void runMain() {
        Intelligence.main(new String[0]);
    }

    @Test
    public void doNotThinksComputerAreSmarter() throws InvalidClauseException {
        String message = "No\\? ";
        runWithInput(String.valueOf(0), new Clause[]{
                new StringLiteral(message)
        });
    }

    @Test
    public void thinksComputerAreSmarter() throws InvalidClauseException {
        String message = "Yes\\? ";
        runWithInput(String.valueOf(1), new Clause[]{
                new StringLiteral(message)
        });
    }
}
