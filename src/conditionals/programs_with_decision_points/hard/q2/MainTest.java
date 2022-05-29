package conditionals.programs_with_decision_points.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
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
        TestOption.defaultInput = "2 3 +";
        return new Clause[]{
                new StringLiteral("Enter operand 1:"),
                new NewLine(),
                new StringLiteral("Enter operand 2:"),
                new NewLine(),
                new StringLiteral("Enter operator \\( \\+, \\-, \\*, \\/ \\):"),
                new NewLine(),
                new PlaceHolder(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Calculator.main(new String[0]);
    }

    public static Stream<Arguments> inputProviderValid(){
        return Stream.of(Arguments.of(2.5, 9.5, "+", 12.0), Arguments.of(-8.4, 9.7, "-", -18.1), Arguments.of(47.9, 7, "*", 335.3),
                Arguments.of(22, 7, "/", 3.142857142857143), Arguments.of(34.95, -96, "*utdhtd", -3355.2));
    }

    public static Stream<Arguments> inputProviderInvalid(){
        return Stream.of(Arguments.of(48, 70.259, "h", "Invalid operator!"), Arguments.of(48.0259, 7846, "^", "Invalid operator!"),
                Arguments.of(465.258, 845.3589, "1*jgfyuuui", "Invalid operator!"));
    }

    @ParameterizedTest
    @MethodSource("inputProviderValid")
    public void worksWithValidOperators(double num1, double num2, String operator, double answer) throws InvalidClauseException {
            TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out the calculator operation.";
            runWithInput(num1 + " " + num2 + " " + operator, new Clause[]{
                    new StringLiteral(num1 + " \\" + operator.charAt(0) + " " + num2 + " = "),
                    new DoubleLiteral("answer")
            });
            assertEquals(Double.parseDouble(getItemByName("answer")), answer, 0.0001, "Your program does not correctly perform one of the calculator operations.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalid")
    public void worksWithInvalidOperators(double num1, double num2, String operator, String message) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out an error message for invalid operations.";
        runWithInput(num1 + " " + num2 + " " + operator, new Clause[]{
                new StringLiteral("Invalid operator!"),
                new StringLiteral("")
        });
    }

}
