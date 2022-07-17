package pre_defined_classes.simple_programs_taking_string_user_input.hard.q4;

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
        TestOption.defaultInput = "Out of the mountain of despair, a stone of hope." + System.lineSeparator() +
                "Out of the mountain of despair, a stone of hope.";
        return new Clause[]{
                new StringLiteral("Enter the first paragraph:"),
                new NewLine(),
                new StringLiteral("Enter the second paragraph:"),
                new NewLine(),
                new StringLiteral("Are the two paragraphs identical\\? "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CompareStrings.main(new String[0]);
    }

    public static Stream<String> inputProviderMatchingStrings() {
        return Stream.of("Out of the mountain of despair, a stone of hope.",
                "Did you ever hear the tragedy of Darth Plagueis The Wise? I thought not. It’s not a story the Jedi would tell you. It’s a Sith legend.",
                System.lineSeparator(), "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe."
        );
    }

    public static Stream<Arguments> inputProviderDifferentStrings() {
        return Stream.of(Arguments.of("Out of the mountain of despair, a stone of hope.",
                        "Did you ever hear the tragedy of Darth Plagueis The Wise? I thought not. It’s not a story the Jedi would tell you. It’s a Sith legend."),
                Arguments.of("Hello, how are you doing today? I am doing well, yourself? Good, just writing some code, you can see how creative I am feeling.",
                        "I know, right????!!!!!"));
    }

    @ParameterizedTest
    @MethodSource("inputProviderMatchingStrings")
    public void worksWithMatchingStrings(String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not work with matching strings.";
        runWithInput(input + System.lineSeparator() + input, new Clause[]{
                new StringLiteral("true")
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderDifferentStrings")
    public void worksWithNonMatchingStrings(String input1, String input2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not work with non-matching strings.";
        runWithInput(input1 + System.lineSeparator() + input2, new Clause[]{
                new StringLiteral("false")
        });
    }

}
