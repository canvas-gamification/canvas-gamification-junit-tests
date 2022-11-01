package methods.modular_programs.hard.q4;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5000";
        return new Clause[]{
                new StringLiteral("How many points did you score\\?"),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        PointsScoring.main(new String[0]);
    }

    static Stream<Arguments> inputValidPointsProvider() {
        return Stream.of(
                Arguments.of(9203, "You won a gold prize!"),
                Arguments.of(5000, "You won a gold prize!"),
                Arguments.of(4999, "You won a silver prize!"),
                Arguments.of(3179, "You won a silver prize!"),
                Arguments.of(2500, "You won a silver prize!"),
                Arguments.of(2499, "You won a bronze prize!"),
                Arguments.of(1833, "You won a bronze prize!"),
                Arguments.of(1000, "You won a bronze prize!"));
    }

    static Stream<Integer> inputInvalidPointsProvider() {
        return Stream.of(999, 0, 1, -1, -2222, 231, -1000);
    }

    @ParameterizedTest
    @MethodSource("inputValidPointsProvider")
    void methodGivePrizeCorrect(int score, String prize) throws Throwable {
        Object[][] arguments = {
                {score, int.class}
        };
        MethodTest m = new MethodTest(PointsScoring.class, "pointsScored", arguments);
        Object output = m.callMethod();
        String errMsg = "Your pointsScored() method does not return the correct prize for the given score.";
        CustomAssertions._assertEquals(prize, output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputInvalidPointsProvider")
    void methodGiveErrorCorrect(int score) throws Throwable {
        Object[][] arguments = {
                {score, int.class}
        };
        MethodTest m = new MethodTest(PointsScoring.class, "pointsScored", arguments);
        Object output = m.callMethod();
        String errMsg = "Your pointsScored() method does not return the correct error message for the given score.";
        CustomAssertions._assertEquals("Sorry, you didn't win any prize.", output, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputValidPointsProvider")
    void printsCorrectPrize(int score, String prize) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct prize for the given score.";
        runWithInput(score + "", new Clause[]{
                new StringLiteral(prize),
        });
    }

    @ParameterizedTest
    @MethodSource("inputInvalidPointsProvider")
    void printsCorrectError(int score) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct error message for the given score.";
        runWithInput(score + "", new Clause[]{
                new StringLiteral("Sorry, you didn't win any prize."),
        });
    }
}
