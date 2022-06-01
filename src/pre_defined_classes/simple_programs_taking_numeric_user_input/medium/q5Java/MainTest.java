package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q5Java;

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
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "4";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new NewLine(),
                new StringLiteral("The square root of "),
                new IntegerLiteral("radicand"),
                new StringLiteral(" is "),
                new DoubleLiteral("root")
        };
    }

    public void runMain() {
        MathSquareRoot.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(4, 2.0), Arguments.of(5, 2.23606797749979), Arguments.of(0, 0), Arguments.of(69, 8.306623862918075),
                Arguments.of(100, 10.0), Arguments.of(189456, 435.265436257004));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void calculatesCorrectValueOfRoot(int input, double output) {
        runWithInput(String.valueOf(input));
        assertEquals(Integer.parseInt(getItemByName("radicand")), input, "Your program does not print out the correct value of the radicand.");
        assertEquals(Double.parseDouble(getItemByName("root")), output, "Your program does not correctly calculate square roots.");
    }

}
