package conditionals.programs_with_decision_points.medium.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "a";

        return new Clause[]{
                new StringLiteral("Enter a character: "),
                new NewLine(),
                new StringLiteral(TestOption.defaultInput),
                new Optional(new StringLiteral(" is a lowercase letter")),
                new Optional(new StringLiteral(" is an uppercase letter")),
                new Optional(new StringLiteral(" is neither uppercase not lowercase"))
        };
    }

    public void runMain() {
        LetterBox.main(new String[0]);
    }

    //check lower-case a and z for if statement, then uppercase, then random symbols
    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("a", 1), Arguments.of("z", 1), Arguments.of("A", 2), Arguments.of("Z", 2), Arguments.of("&", 3), Arguments.of("/", 3));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInputLate(String input, int version) {
        runWithInput(input);
        String message, error;
        if (version == 1) {
            message = " is a lowercase letter";
            error = "Your program did not correctly identify a lowercase letter. Check your if statement.";
        } else if (version == 2) {
            message = " is an uppercase letter";
            error = "Your program did not correctly identify an uppercase letter. Check your if statement.";
        } else {
            message = " is neither uppercase not lowercase";
            error = "Your program did not correctly identify that the input was not uppercase or lowercase. Check your if statement.";
        }
        String output = getOutput();
        assertTrue(output.contains(message), error);
    }

    @Test
    void doubleMessageTest() {
        runWithInput("a");
        String output = getOutput();
        assertTrue(output.contains(" is a lowercase letter") ^ output.contains(" is an uppercase letter") ^ output.contains(" is neither uppercase not lowercase"), "Your program prints both possible responses to the input.");
    }
}
