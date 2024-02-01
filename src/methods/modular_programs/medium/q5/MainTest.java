package methods.modular_programs.medium.q5;

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
        TestOption.defaultInput = "33";
        return new Clause[]{
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        DivSeries.main(new String[0]);
    }

    static Stream<Arguments> inputSeriesProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 20),
                Arguments.of(6, 48),
                Arguments.of(12, 58),
                Arguments.of(16, 62),
                Arguments.of(19, 65),
                Arguments.of(20, 66),
                Arguments.of(23, 66),
                Arguments.of(33, 66),
                Arguments.of(23999, 66));
    }

    @ParameterizedTest
    @MethodSource("inputSeriesProvider")
    public void correctSeriesOutput(int n, int expectedSum) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct sum of the series.";
        runWithInput(n + "", new Clause[][]{{
                new StringLiteral("The sum of the series is "),
                new IntegerLiteral(expectedSum),
        }});
    }

    @ParameterizedTest
    @MethodSource("inputSeriesProvider")
    public void correctSumMethod(int n, int ans) throws Throwable {
        Object[][] arguments = {
                {n, int.class}
        };
        MethodTest m = new MethodTest(DivSeries.class, "divisionCalc", arguments);
        Object output = m.callMethod();
        _assertEquals(ans, output,
                "Your divisionCalc method does not return the correct sum of the series based on the input n.");
    }
}
