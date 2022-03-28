package conditionals.simple_programs_with_decision_points.hard.q6;

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
        TestOption.defaultInput = "150";

        return new Clause[]{
                new StringLiteral("Enter your current temperature \\( in fahrenheit \\): "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        TempCalc.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("100", "You have a fever. Stay at home and rest."), Arguments.of("90", "You don't have a fever. Have fun out there!"), Arguments.of("115", "You have a fever. Stay at home and rest."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInputLate(String temperature, String message) throws InvalidClauseException {
        runWithInput(temperature, new Clause[]{
                new StringLiteral(message)
        });
    }
}
