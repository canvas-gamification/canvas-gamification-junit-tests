package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q5;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
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
        TestOption.defaultInput = "4";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new StringLiteral("The square root of "),
                new IntegerLiteral("radicand"),
                new StringLiteral(" is "),
                new DoubleLiteral("squareRoot")
        };
    }

    public void runMain() {
        MathSquareRoot.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(4, 2.0), Arguments.of(100, 10.0), Arguments.of(7, 2.6457513110645907), Arguments.of(24, 4.898979485566356));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctlyCalculatesSquareRoot(int radicand, Double squareRoot) {
        runWithInput(radicand + System.lineSeparator());
        assertEquals(Integer.parseInt(getItemByName("radicand")), radicand, "Your program does not correctly print the radicand");
        assertEquals(Double.parseDouble(getItemByName("squareRoot")), squareRoot, "Your program does not correctly calculate the square root of a number");
    }
}
