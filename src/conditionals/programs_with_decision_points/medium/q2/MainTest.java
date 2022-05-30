package conditionals.programs_with_decision_points.medium.q2;

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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "90.8";
        return new Clause[]{
                new StringLiteral("Enter your grade in percentage:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        LetterGrade.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(90, "A\\+"), Arguments.of(95.8, "A\\+"), Arguments.of(89.99, "A"), Arguments.of(80, "A"),
                Arguments.of(83.69, "A"), Arguments.of(70, "B"), Arguments.of(79.45, "B"), Arguments.of(76.92, "B"),
                Arguments.of(69.934, "C"), Arguments.of(60, "C"), Arguments.of(68.567, "C"), Arguments.of(50, "D"), Arguments.of(59.34, "D"),
                Arguments.of(54.97, "D"), Arguments.of(49.457, "F"), Arguments.of(0, "F"), Arguments.of(27.6, "F"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printsCorrectLetterGrade(double percent, String grade) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct letter grade for the given percent.";
        runWithInput(String.valueOf(percent), new Clause[]{
                new StringLiteral(grade)
        });
    }
}
