package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q3;

import global.BaseTest;
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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5 -5";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new StringLiteral("Enter another number: "),
                new NewLine(),
                new StringLiteral("Before swapping: x = "),
                new IntegerLiteral("x"),
                new StringLiteral(", y = "),
                new IntegerLiteral("y"),
                new NewLine(),
                new StringLiteral("After swapping: x = "),
                new IntegerLiteral("xSwap"),
                new StringLiteral(", y = "),
                new IntegerLiteral("ySwap")
        };
    }

    public void runMain() {
        SwappingGoodness.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(-5, 47), Arguments.of(0, 5), Arguments.of(-5, -7), Arguments.of(34, 11));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctlyPrintsNumbersBeforeSwapping(int x, int y) {
        runWithInput(x + System.lineSeparator() + y);
        assertEquals(Integer.parseInt(getItemByName("x")), x, "Your program is not correctly printing the two numbers before swapping.");
        assertEquals(Integer.parseInt(getItemByName("y")), y, "Your program is not correctly printing the two numbers before swapping.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctlySwapsNumbers(int x, int y) {
        runWithInput(x + System.lineSeparator() + y);
        assertEquals(Integer.parseInt(getItemByName("xSwap")), y, "Your program is not correctly swapping the two numbers.");
        assertEquals(Integer.parseInt(getItemByName("ySwap")), x, "Your program is not correctly swapping the two numbers.");
    }
}
