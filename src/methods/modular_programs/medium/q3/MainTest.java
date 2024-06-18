package methods.modular_programs.medium.q3;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

import static global.tools.CustomAssertions._assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "12";
        return new Clause[]{
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        AlternateIt.main(new String[0]);
    }

    static Stream<Arguments> inputUpperBoundProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(12, -6),
                Arguments.of(13, 7),
                Arguments.of(2, -1),
                Arguments.of(1233, 617),
                Arguments.of(992, -496));
    }

    @ParameterizedTest
    @MethodSource("inputUpperBoundProvider")
    public void printsCorrectOutput(int upperBound, int expectedSum) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message of the series sum.";
        runWithInput(upperBound + "", new Clause[][]{{
                new StringLiteral("The sum of the series is: "),
                new IntegerLiteral(expectedSum),
        }});
    }

    @ParameterizedTest
    @MethodSource("inputUpperBoundProvider")
    public void correctSumCalcMethod(int n, int ans) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(AlternateIt.class, "sumCalc", arguments);
        Object output = m.callMethod();
        _assertEquals(ans, output, "your sumCalc method does not return the correct sum of the series.");
    }
}
