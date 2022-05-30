package conditionals.simple_programs_with_decision_points.hard.q7;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5 8";

        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new IntegerLiteral("minimum"),
                new StringLiteral(" is the min")
        };
    }

    public void runMain() {
        MaxItOut.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(-7, 6, -7), Arguments.of(90, 41, 41), Arguments.of(-11, -9, -11), Arguments.of(0, 0, 0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsMinimumNumber(int n1, int n2, int min) {
        runWithInput(n1 + " " + n2);
        assertEquals(Integer.parseInt(getItemByName("minimum")), min, "Your program does not print the minimum value.");
    }
}
