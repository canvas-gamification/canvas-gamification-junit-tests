package pre_defined_classes.simple_programs_taking_string_user_input.hard.q9;

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
        TestOption.defaultInput = "Hello world";
        return new Clause[]{
                new StringLiteral("Please enter a sentence: "),
                new NewLine(),
                new StringLiteral("Does the sentence contain the word computer\\? "),
                new PlaceHolder(),
                new NewLine(),
                new StringLiteral("Does the sentence contain the word science\\? "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SentenceSearch.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Hello, how are you?", false, false),
                Arguments.of("Computer science is my favourite.", true, true),
                Arguments.of("It is science Sunday today.", false, true),
                Arguments.of("I bought a new computer yesterday.", true, false),
                Arguments.of("Guess what time it is?", false, false),
                Arguments.of("On Tuesdays, my only courses are Computer Science and Mathematics.", true, true)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void searchesStringCorrectly(String sentence, boolean contains1, boolean contains2) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly detect if the input sentence contains the words computer or science.";
        runWithInput(sentence, new Clause[]{
                new StringLiteral(String.valueOf(contains1)),
                new StringLiteral(String.valueOf(contains2))
        });
    }
}
