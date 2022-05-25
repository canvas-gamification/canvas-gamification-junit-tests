package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
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
        TestOption.defaultInput = "5 5";
        return new Clause[]{
                new StringLiteral("Please enter two integers to add: "),
                new NewLine(),
                new StringLiteral("The answer is: "),
                new IntegerLiteral("answer")
        };
    }

    public void runMain() {
        ArithmeticStar.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(2, 3, 5), Arguments.of(-4, 2, -2), Arguments.of(1056, 346, 1402),
                Arguments.of(-4537, -486, -5023), Arguments.of(0, -5, -5), Arguments.of(-100, 0, -100));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void addsNumbersCorrectly(int n1, int n2, int sum) throws InvalidClauseException {
        runWithInput(n1 + " " + n2);
        assertEquals(Integer.parseInt(getItemByName("answer")), sum, "Please make sure your program is correctly adding two numbers.");
    }
}
