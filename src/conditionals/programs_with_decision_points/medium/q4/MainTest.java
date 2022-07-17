package conditionals.programs_with_decision_points.medium.q4;

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
        TestOption.defaultInput = "4 4";
        return new Clause[]{
                new StringLiteral("Enter the number of strokes you took for this course: "),
                new NewLine(),
                new StringLiteral("Enter the number of strokes you need for par: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ForeGolf.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(3, 3, "Par"), Arguments.of(7, 6, "Bogey"), Arguments.of(8, 4, "No Scoring Term"),
                Arguments.of(2, 3, "Birdie"), Arguments.of(5, 7, "Eagle"), Arguments.of(5, 3, "Double Bogey"),
                Arguments.of(2, 16, "No Scoring Term"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectGolfTerm(int strokes, int par, String output) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct golf term based on the number of strokes and par input.";
        runWithInput(strokes + " " + par, new Clause[]{
                new StringLiteral(output)
        });
    }
}
