package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "4";
        return new Clause[]{
                new StringLiteral("How many bags are you checking in\\? "),
                new NewLine(),
                new StringLiteral("The baggage fee is \\$"),
                new IntegerLiteral("fee")
        };
    }

    public void runMain() {
        AirlineBaggage.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(4, 100), Arguments.of(69, 1725), Arguments.of(0, 0), Arguments.of(2, 50));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesBaggageFeeCorrectly(int numBags, int fee) throws InvalidClauseException {
        runWithInput(numBags + System.lineSeparator());
        assertEquals(Integer.parseInt(getItemByName("fee")), fee, "Your program does not correctly calculate the baggage fee.");
    }
}
