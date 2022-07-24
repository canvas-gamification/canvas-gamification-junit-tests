package conditionals.simple_programs_with_decision_points.hard.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral("absoluteValue")
        };
    }

    public void runMain() {
        AbsolutelySure.main(new String[]{});
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(5, 5, "The absolute value of positive numbers was calculated incorrectly."), Arguments.of(-46, 46, "The absolute value of negative numbers was calculated incorrectly."), Arguments.of(0, 0, "The absolute value of zero was calculated incorrectly."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, int output, String error) {
        runWithInput(input + "");
        assertEquals(Integer.parseInt(getItemByName("absoluteValue")), output, error);
    }

}
