package conditionals.simple_programs_with_decision_points.hard.q3;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons with distractors

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "22 31";

        return new Clause[]{
                new StringLiteral("Current Time Hours \\(in a 24h clock\\): "),
                new NewLine(),
                new StringLiteral("Current Time Minutes:  "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SleepyTime.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(22, 31, "Please go to sleep."), Arguments.of(22, 24, "Please go to sleep."), Arguments.of(20, 56, "The night is still young!"), Arguments.of(18, 1, "The night is still young!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int hours, int minutes, String message) throws InvalidClauseException {
        runWithInput((hours + " ") + (minutes + ""), new Clause[]{
                new StringLiteral(message, "message")
        });

    }
}
