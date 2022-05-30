package conditionals.programs_with_decision_points.hard.q5;

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
        TestOption.defaultInput = "1 1";
        return new Clause[]{
                new StringLiteral("Is it sunny outside\\? \\( Enter 1 for yes and 0 for no \\)"),
                new NewLine(),
                new StringLiteral("Is it past noon\\? \\( Enter 1 for yes and 0 for no \\)"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        WeatherIGo.main(new String[0]);
    }

    public static Stream<Arguments> inputProviderValid(){
        return Stream.of(Arguments.of(0 ,0 ,"Stay Inside!"), Arguments.of(1, 0, "Wear your normal clothes!"),
                Arguments.of(0, 1, "Wear a jacket before leaving!"), Arguments.of(1, 1, "Wear some sunscreen and a pair of sunglasses before leaving!"));
    }

    public static Stream<Arguments> inputProviderInvalid(){
        return Stream.of(Arguments.of(0, 2, "Invalid input!"), Arguments.of(2, 1, "Invalid input!"),
                Arguments.of(-1, -1, "Invalid input!"), Arguments.of(-1, 0, "Invalid input!"), Arguments.of(0, -1, "Invalid input!"));
    }

    @ParameterizedTest
    @MethodSource("inputProviderValid")
    public void printsCorrectMessageWithValidInput(int sunny, int noon, String userMessage) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct user action when given valid input.";
        runWithInput(sunny + " " + noon, new Clause[]{
                new StringLiteral(userMessage)
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalid")
    public void printsCorrectMessageWithInvalidInput(int sunny, int noon, String userMessage) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message when given invalid user input.";
        runWithInput(sunny + " " + noon, new Clause[]{
                new StringLiteral(userMessage)
        });
    }
}
