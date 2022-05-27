package pre_defined_classes.simple_programs_taking_string_user_input.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Pearl";
        return new Clause[]{
                new StringLiteral("Enter a word:"),
                new NewLine(),
                new StringLiteral("The word is changed to: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        removeVowel.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("pearl", "peerl"), Arguments.of("suspicious", "sespeceees"),
                Arguments.of("incomprehensibility", "encemprehensebelety"), Arguments.of(System.lineSeparator(), ""),
                Arguments.of("tiara", "teere"), Arguments.of("aeiou", "eeeee"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void replacesVowelCorrectly(String word, String changedWord) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly replace all the vowels in a word with e.";
        runWithInput(word, new Clause[]{
                new StringLiteral(changedWord)
        });
    }
}
