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

    static Stream<Character> lowerInputProvider() {
        return Stream.of('a', 'f', 'z');
    }

    static Stream<Character> upperInputProvider() {
        return Stream.of('A', 'S', 'Z');
    }

    static Stream<Character> neitherInputProvider() {
        return Stream.of('&', '/', '0');
    }

    @ParameterizedTest
    @MethodSource("lowerInputProvider")
    void worksWithLowercaseCharacters(char input) throws InvalidClauseException {
        String message = input + " is a lowercase letter";
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify a lower case letter.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(message)
        });
    }

    @ParameterizedTest
    @MethodSource("upperInputProvider")
    void worksWithUppercaseCharacters(char input) throws InvalidClauseException {
        String message = input + " is an uppercase letter";
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify an upper case letter.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(message)
        });
    }

    @ParameterizedTest
    @MethodSource("neitherInputProvider")
    void worksWithOtherCharacters(char input) throws InvalidClauseException {
        String message = input + " is neither uppercase nor lowercase";
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify an input that is neither lower case nor uppercase.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(message)
        });
    }
}
