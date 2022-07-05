package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q7;

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
        TestOption.defaultInput = "78 ";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new NewLine(),
                new StringLiteral("The remainder value is: "),
                new IntegerLiteral("remainder")
        };
    }

    public void runMain() {OddOrEven.main(new String[0]);}

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(78, 0), Arguments.of(77, 1), Arguments.of(0, 0),
                Arguments.of(-2, 0), Arguments.of(-1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void determineOddOrEvenCorrectly(int num, double remainder) throws InvalidClauseException {
        runWithInput(num + System.lineSeparator());
        assertEquals(Integer.parseInt(getItemByName("remainder")), remainder, "Your program does not correctly calculate if a number is odd or even");
    }
}
