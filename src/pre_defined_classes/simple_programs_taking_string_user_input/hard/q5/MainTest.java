package pre_defined_classes.simple_programs_taking_string_user_input.hard.q5;

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
        TestOption.defaultInput = "The French Dip with mushrooms, a side of fries, and gravy please.";
        return new Clause[]{
                new StringLiteral("Hello, welcome to FakeOK restaurant."),
                new NewLine(),
                new StringLiteral("What is your order\\?"),
                new NewLine(),
                new StringLiteral("Great, I'll be back with: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        orderHalf.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("The French Dip with mushrooms, a side of fries, and gravy please.", "The French Dip with mushrooms, a"),
                Arguments.of("Just a coffee with cream for me please.", "Just a coffee with "), Arguments.of(System.lineSeparator(), ""),
                Arguments.of("I have run out of ideas of orders to try.", "I have run out of id"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsHalfOfInputCorrectly(String input, String halfInput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print out half of the order.";
        runWithInput(input, new Clause[]{
                new StringLiteral(halfInput)
        });
    }
}
