package pre_defined_classes.simple_porgrams_taking_string_user_input.medium.q5;

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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "boot";
        return new Clause[]{
                new StringLiteral("Enter a word: "),
                new NewLine(),
                new StringLiteral("The plural form may be "),
                new PlaceHolder(),
                new StringLiteral(" or "),
                new PlaceHolder(),
                new StringLiteral(".")
        };
    }

    public void runMain() {
        WordPluralizer.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("boot", "boots", "bootes"), Arguments.of("people", "peoples", "peoplees"),
                Arguments.arguments("computer", "computers", "computeres"), Arguments.of("lady", "ladys", "ladyes"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsPluralFormsCorrectly(String word, String plural1, String plural2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the common plural forms of the noun.";
        runWithInput(word, new Clause[]{
                new StringLiteral(plural1, "pluralS"),
                new StringLiteral(plural2, "pluralES")
        });
    }
}
