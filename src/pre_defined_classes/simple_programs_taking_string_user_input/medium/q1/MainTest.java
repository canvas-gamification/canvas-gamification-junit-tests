package pre_defined_classes.simple_programs_taking_string_user_input.medium.q1;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
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
        TestOption.defaultInput = "John Doe " + System.lineSeparator() + 45;
        return new Clause[]{
                new StringLiteral("What's your name\\?"),
                new NewLine(),
                new StringLiteral("How old are you\\?"),
                new NewLine(),
                new StringLiteral("Hi "),
                new PlaceHolder(),
                new StringLiteral(", you are "),
                new PlaceHolder(),
                new StringLiteral(" years old\\!")
        };
    }

    public void runMain() {
        Greetings.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("John Doe", 45), Arguments.of("Seth", 20), Arguments.of("Amelia Earhart", 0),
                Arguments.of("Teresa", 21), Arguments.of("Steve Steveson", 157));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void producesGreetingCorrectly(String name, int age) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print out the correct greeting.";
        runWithInput(name + System.lineSeparator() + age, new Clause[]{
                new StringLiteral(name),
                new IntegerLiteral(age)
        });
    }
}
