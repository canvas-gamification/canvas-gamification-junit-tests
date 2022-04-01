package conditionals.programs_with_decision_points.medium.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "a";

        return new Clause[]{
                new StringLiteral("Enter a character: "),
                new NewLine(),
                new PlaceHolder()
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
    void testWithInputLate(String input, int version) throws InvalidClauseException {

        String message;
        if (version == 1) {
            message = input + " is a lowercase letter";
        } else if (version == 2) {
            message = input + " is an uppercase letter";
        } else {
            message = input + " is neither uppercase not lowercase";
        }

        runWithInput(input, new Clause[]{
                new StringLiteral(message)
        });
    }
}
