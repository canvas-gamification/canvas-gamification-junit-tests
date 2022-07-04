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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "0";
        return new Clause[]{
                new StringLiteral("Do you think computers are smarted than humans \\(0 for no, 1 for yes\\)\\?"),
                new NewLine(),
                new IntegerLiteral("input"),
                new StringLiteral(" is "),
                new RandomInteger(0, 101),
                new StringLiteral("\\% correct\\.")
        };
    }

    public void runMain() {
        Intelligence.main(new String[0]);
    }

    @Test
    public void doNotThinksComputerAreSmarter() throws InvalidClauseException {
        runWithInput(String.valueOf(0));
        assertEquals(Integer.parseInt(getItemByName("input")), 0,
                "Your program does not correctly print the percentage based on an answer No.");
    }

    @Test
    public void thinksComputerAreSmarter() throws InvalidClauseException {
        runWithInput(String.valueOf(1));
        assertEquals(Integer.parseInt(getItemByName("input")), 1,
                "Your program does not correctly print the percentage based on an answer Yes.");
    }
}
