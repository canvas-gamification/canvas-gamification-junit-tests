package conditionals.programs_with_decision_points.hard.q1;

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
        TestOption.defaultInput = "20 30";
        return new Clause[]{
                new StringLiteral("Current Time Hours \\(in a 24h clock\\): "),
                new NewLine(),
                new StringLiteral("Current Time Minutes: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SleepyTimeAgain.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(1, 45, "The night is still young!"), Arguments.of(20, 38, "The night is still young!"),
                Arguments.of(21, 30, "Please go to sleep."), Arguments.of(24, 0, "Invalid time!"), Arguments.of(0, 0, "The night is still young!"),
                Arguments.of(15, 60, "Invalid time!"), Arguments.of(-1, 40, "Invalid time!"), Arguments.of(21, 29, "The night is still young!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectMessage(int hours, int minutes, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message based on the time";
        runWithInput(hours + " " + minutes, new Clause[]{
                new StringLiteral(message)
        });
    }
}
