package conditionals.simple_programs_with_decision_points.hard.q4;

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
        TestOption.defaultInput = "true";

        return new Clause[]{
                new StringLiteral("Is the door open or closed right now\\? \\(Enter true for open and false for closed\\)"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        DoorBoy.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("true", "I will close the door"), Arguments.of("false", "Time to open the door"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String open, String message) throws InvalidClauseException {
        runWithInput(open, new Clause[]{
                new StringLiteral(message)
        });
    }
}
