package conditionals.simple_programs_with_decision_points.hard.q5;

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
    // Parsons with distractors

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
        CharaComb.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("a", "Vowel"), Arguments.of("e", "Vowel"), Arguments.of("i", "Vowel"), Arguments.of("o", "Vowel"), Arguments.of("u", "Vowel"), Arguments.of("k", "Not a vowel"), Arguments.of("b", "Not a vowel"), Arguments.of("x", "Not a vowel"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String letter, String message) throws InvalidClauseException {
        runWithInput(letter, new Clause[]{
                new StringLiteral(message)
        });
    }
}
