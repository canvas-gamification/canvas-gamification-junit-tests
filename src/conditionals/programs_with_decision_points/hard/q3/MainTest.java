package conditionals.programs_with_decision_points.hard.q3;

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
        TestOption.defaultInput = "1 1 2022";
        return new Clause[]{
                new StringLiteral("Enter Day \\(DD\\):"),
                new NewLine(),
                new StringLiteral("Enter Month \\(MM\\):"),
                new NewLine(),
                new StringLiteral("Enter Year \\(YYYY\\):"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SaveTheDate.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider(){
            return Stream.of(Arguments.of(31, 12, 1000, "Valid Date!"), Arguments.of(1, 1, 9999, "Valid Date!"),
                    Arguments.of(30, 5, 2022, "Valid Date!"), Arguments.of(0, 2, 8529, "Invalid Day!"), Arguments.of(32, 4, 2028, "Invalid Day!"),
                    Arguments.of(4, 13, 2025, "Invalid Month!"), Arguments.of(11, 0, 2002, "Invalid Month!"), Arguments.of(4, 4, 999, "Invalid Year!"),
                    Arguments.of(24, 6, 10000, "Invalid Year!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void checksDateCorrectly(int day, int month, int year, String message) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly verify the date.";
        runWithInput(day + " " + month + " " + year, new Clause[]{
                new StringLiteral(message)
        });
    }
}
