package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q8;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "4 ";
        return new Clause[]{
                new StringLiteral("Enter a number\\: " ),
                new NewLine(),
                new StringLiteral("The square root value of the given number is\\: "),
                new DoubleLiteral("sqrt")
        };
    }

    public void runMain() {
        FeelingSophisticated.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(4, 2.0), Arguments.of(5, 2.23606797749979),
                Arguments.of(0, 0.0), Arguments.of(12.25, 3.5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSquareRootCorrectly(double input, double sqrt) throws InvalidClauseException {
        runWithInput(input + " ");
        assertEquals(Double.parseDouble(getItemByName("sqrt")), sqrt, 0.00001,
                "Your program does not correctly calculate the square root of the input.");
    }
}
