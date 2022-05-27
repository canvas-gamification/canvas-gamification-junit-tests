package pre_defined_classes.simple_programs_taking_string_user_input.hard.q2;

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
    // BooleanLiteral
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Imagine Dragons" + System.lineSeparator() + "Dragons";
        return new Clause[]{
                new StringLiteral("What is the name of your favourite band\\?"),
                new NewLine(),
                new StringLiteral("What is your favourite word\\?"),
                new NewLine(),
                new StringLiteral("Does the band end with your favourite word\\? "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        CheckEnding.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("Imagine Dragons", "Dragons", true), Arguments.of("Imagine Dragons", "Tires", false),
                Arguments.of(System.lineSeparator(), System.lineSeparator(), true), Arguments.of("Petty Tomfoolery", "potato", false),
                Arguments.of("The Coffee Monster", "monster", false), Arguments.of("It is time", "time", true));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void checksStringEndingCorrectly(String input1, String input2, boolean contains) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the boolean value if the first string ends with the second string.";
        runWithInput(input1 + System.lineSeparator() + input2, new Clause[]{
                new StringLiteral(Boolean.toString(contains), "contains")
        });
    }
}
