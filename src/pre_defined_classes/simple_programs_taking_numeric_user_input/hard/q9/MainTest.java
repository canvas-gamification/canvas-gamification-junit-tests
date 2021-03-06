package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q9;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "2 5 ";
        return new Clause[]{
                new StringLiteral("Enter a base\\:"),
                new NewLine(),
                new StringLiteral("Enter an exponent\\:"),
                new NewLine(),
                new DoubleLiteral("base"),
                new StringLiteral(" to the power of "),
                new DoubleLiteral("exponent"),
                new StringLiteral(" is "),
                new DoubleLiteral("result")
        };
    }

    public void runMain() {
        MathPowerUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(2, 5, 32.0), Arguments.of(0, 0, 1.0),
                Arguments.of(-3, 2, 9.0), Arguments.of(-3, 5, -243.0),
                Arguments.of(4, -3, 0.015625), Arguments.of(3.5, 2, 12.25), Arguments.of(3, 2.5, 15.5884572681)
                );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesPowerCorrectly(double base, double exponent, double result) throws InvalidClauseException {
        runWithInput(base + " "+ exponent );
        assertEquals(Double.parseDouble(getItemByName("result")), result, 0.00001,
                "Your program does not correctly calculate the power given the base number and the exponent number.");
    }


}
