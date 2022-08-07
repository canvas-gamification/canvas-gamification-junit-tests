package loops.simple_programs_with_repetition.medium.q7;

import global.variables.*;
import global.variables.clauses.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a number for the upper bound of the series:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SeriesSeries.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(12, 650),
                Arguments.of(45, 31395),
                Arguments.of(48975, 2.784029941164E13)
        );
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -10, -46893);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void calculatesSumOfSeriesCorrectly(int input, double sum) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly output the sum of the series.";
        runWithInput(String.valueOf(input), new Clause[][]{{
                new StringLiteral("The sum of the series is: "),
                new DoubleLiteral("seriesSum")
        }});
        assertEquals(Double.parseDouble(getItemByName("seriesSum")), sum, 0.0000001, "Your program does not correctly calculate the sum of the series.");
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid input!")
        });
    }
}
