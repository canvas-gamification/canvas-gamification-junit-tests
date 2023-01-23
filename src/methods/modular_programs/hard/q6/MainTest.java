package methods.modular_programs.hard.q6;

import java.util.stream.Stream;

import global.MethodTest;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public static final double cn = 1.15;
    public static final double cy = 1.20;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "120 N";
        return new Clause[]{
                new StringLiteral("Enter the cost of the food:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Was the service great\\? \\(Enter Y\\/N\\)"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        DinnerCost.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(120.0, 'N', 120.0 * cn),
                Arguments.of(120.0, 'Y', 120.0 * cy),
                Arguments.of(100.0, 'N', 100.0 * cn),
                Arguments.of(100.0, 'Y', 100.0 * cy),
                Arguments.of(0.0, 'N', 0.0),
                Arguments.of(0.0, 'Y', 0.0),
                Arguments.of(1000.0, 'N', 1000.0 * cn),
                Arguments.of(1000.0, 'Y', 1000.0 * cy),
                Arguments.of(7877.0, 'N', 7877.0 * cn),
                Arguments.of(7877.0, 'Y', 7877.0 * cy),
                Arguments.of(3.0, 'Y', 3.0 * cy),
                Arguments.of(3.0, 'N', 3.0 * cn),
                Arguments.of(111.223, 'Y', 111.223 * cy),
                Arguments.of(92.121, 'N', 92.121 * cn),
                Arguments.of(3.33, 'Y', 3.33 * cy),
                Arguments.of(3.51, 'N', 3.51 * cn));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodReturnsCorrectTotal(double costOfFood, char service, double totalCost) throws Throwable {
        Object[][] arguments = {
                {costOfFood, double.class},
                {service, char.class}
        };
        MethodTest m = new MethodTest(DinnerCost.class, "foodCost", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(totalCost, output, "Your foodCost method does not return the correct cost to be paid.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectDinnerCost(double costOfFood, char service, double totalCost) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct total cost of dinner for the given input.";
        runWithInput(costOfFood + " " + service, new Clause[]{
                new StringLiteral("For dinner, you will pay " + totalCost + " dollars.")
        });
    }
}
