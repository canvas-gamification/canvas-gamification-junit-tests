package pre_defined_classes.simple_programs_taking_string_user_input.hard.q1;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "hello";
        return new Clause[]{
                new StringLiteral("Enter a string:"),
                new NewLine(),
                new StringLiteral("Is the given string already all lowercase\\? "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        UpperOrLower.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("hello", true), Arguments.of(
                "It's a dangerous business, Frodo, going out your door. You step onto the road, and if you don't keep your feet, there's no knowing where you might be swept off to.",
                false), Arguments.of(System.lineSeparator(), true), Arguments.of("hi, how are you doing today?", true), Arguments.of("I am doing quite well. Thank you", false));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void checksIfLowerCaseCorrectly(String input, boolean isLowerCase) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print if the given string is all lower case.";
        runWithInput(input, new Clause[]{
                new StringLiteral("[true|false|" + input.toLowerCase() + "|" + input.toUpperCase() + "]", "isLowerCase")
        });
    }
}
