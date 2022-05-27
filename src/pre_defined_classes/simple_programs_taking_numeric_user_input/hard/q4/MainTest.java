package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q4;

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
        TestOption.defaultInput = "100.00 ";
        return new Clause[]{
                new StringLiteral("Enter the cost of the groceries before the discount: "),
                new NewLine(),
                new StringLiteral("The discounted cost is \\$"),
                new DoubleLiteral("cost")
        };
    }

    public void runMain() {
        Discount.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(100.00, 90.0), Arguments.of(56.78, 51.10), Arguments.of(978.45, 880.61),
                Arguments.of(74.20, 66.78), Arguments.of(0.0, 0.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesDiscountCostCorrectly(double price, double cost) throws InvalidClauseException {
        runWithInput(price + System.lineSeparator());
        assertEquals(Double.parseDouble(getItemByName("cost")), cost, 0.01, "Your program does not correctly calculate the cost after the discount.");
    }
}
