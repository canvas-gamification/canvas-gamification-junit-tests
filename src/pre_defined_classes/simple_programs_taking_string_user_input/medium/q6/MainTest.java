package pre_defined_classes.simple_programs_taking_string_user_input.medium.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "I think so\\.";
        return new Clause[]{
                new StringLiteral("Enter any sentence\\: "),
                new NewLine(),
                new StringLiteral("Does the sentence contain any spaces\\? "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() { HasSpace.main(new String[0]);}

    static Stream<String> stringWithSpace() {
        return Stream.of("The inner machinations of my mind are an enigma.", "(stu\\#:123 456)"
                , "it\\'s a sunny day", "I think so\\.", " "
        );
    }

    static Stream<String> stringWithNoSpace() {

        return Stream.of("abc.", "1234", "EmptyStringDoesNotWork", "b",
                System.lineSeparator()
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithSpace")
    public void correctlyDetectSpace(String sentence) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print true when there is a space in the inputted sentence.";
        runWithInput(sentence, new Clause[]{
                new StringLiteral("true")
        });
    }

    @ParameterizedTest
    @MethodSource("stringWithNoSpace")
    public void correctlyDetectNoSpace(String sentence) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not correctly print false when there is a space in the inputted sentence.";
        runWithInput(sentence, new Clause[]{
                new StringLiteral("false"),
        });
    }
}