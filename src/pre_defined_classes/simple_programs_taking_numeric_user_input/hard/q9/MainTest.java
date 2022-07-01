package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
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
        TestOption.defaultInput = "2 5 32.0";
        return new Clause[]{
                new StringLiteral("Enter a base:"),
                new StringLiteral("Enter an exponent:"),
                new IntegerLiteral("base"),
                new StringLiteral(" to the power of "),
                new IntegerLiteral("exponent"),
                new StringLiteral(" is "),
                new DoubleLiteral("result")
        };
    }

    public void runMain() {
        MathPowerUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(2, 5, 32.0), Arguments.of(0, 0, 1.0), Arguments.of(-3, 2, 9.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesPowerCorrectly(int base, int exponent, double result) throws InvalidClauseException {
        runWithInput(base + " "+ exponent);
        assertEquals(Double.parseDouble(getItemByName("result")), result);
    }


}
