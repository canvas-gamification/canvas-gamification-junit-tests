package conditionals.simple_programs_with_decision_points.medium.q8;

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
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "60 60 60";
        return new Clause[]{
                new StringLiteral("Enter angle 1 in degrees: "),
                new NewLine(),
                new StringLiteral("Enter angle 2 in degrees: "),
                new NewLine(),
                new StringLiteral("Enter angle 3 in degrees: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        TryAngle.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(90, 90, 90, "How can you even have a perfectly closed 3-sided shape without the angles being 180\\?\\?\\?!!\\?"),
                Arguments.of(60, 60, 60, "Now that's a valid triangle!"), Arguments.of(33.5, 77.8, 68.7, "Now that's a valid triangle!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(double angle1, double angle2, double angle3, String triangleOutput) throws InvalidClauseException {
        runWithInput(angle1 + System.lineSeparator() + angle2 + System.lineSeparator() + angle3, new Clause[]{
                new StringLiteral(triangleOutput)
        });
    }

}
