package pre_defined_classes.simple_programs_taking_user_input.hard.q1;

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
        TestOption.defaultInput = "10 10 10";

        return new Clause[]{
                new StringLiteral("How many hours have you worked\\?"),
                new NewLine(),
                new StringLiteral("What is your hourly wage\\?"),
                new NewLine(),
                new StringLiteral("What is the tax rate\\? \\(Enter 0\\.12 for 12\\%\\)"),
                new NewLine(),
                new StringLiteral("Pay Amount: "),
                new DoubleLiteral("pay"),
                new NewLine(),
                new StringLiteral("Tax Amount: "),
                new DoubleLiteral("tax"),
                new NewLine(),
                new StringLiteral("Net Earnings: "),
                new DoubleLiteral("net")
        };
    }

    public void runMain() {
        PayrollTax.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(48.75, 59.86, 0.16, 2918.175, 466.908, 2451.267),
                Arguments.of(17.50, 45, 0.10, 787.5, 78.75, 708.75),
                Arguments.of(34.79, 39.75, 0.20, 1382.9025, 276.5805, 1106.322));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(double hours, double wage, double taxRate, double pay, double tax, double earnings) throws InvalidClauseException {
        runWithInput(hours + System.lineSeparator() + wage + System.lineSeparator() + taxRate + System.lineSeparator());
        assertEquals(Double.parseDouble(getItemByName("pay")), pay, 0.001, "Calculated pay amount is incorrect");
        assertEquals(Double.parseDouble(getItemByName("tax")), tax, 0.001, "Calculated tax amount is incorrect");
        assertEquals(Double.parseDouble(getItemByName("net")), earnings, 0.001, "Calculated net earnings is incorrect");
    }
}
