package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q6;

import global.BaseRandomTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
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

    public static Stream<Integer> inputProvider(){ return Stream.of (0, 1);}

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectOutput(int input) throws InvalidClauseException {
        runWithInput(String.valueOf(input));
        assertEquals(Integer.parseInt(getItemByName("input")), input,
                "Your program does not correctly print the output based on the input provided.");
    }
}
