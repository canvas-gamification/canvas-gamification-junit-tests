package loops.simple_programs_with_repetition.medium.q6;

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
        SumthingSerious.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0.5),
                Arguments.of(15, 12.6192710068),
                Arguments.of(456, 450.297007251),
                Arguments.of(10578, 10569.1561109)
        );
    }

    static Stream<Arguments> invalidInputProvider() {
        return Stream.of(
                Arguments.of(-1, "Invalid input!"),
                Arguments.of(-4592, "Invalid input!"),
                Arguments.of(-2, "Invalid input!")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSumOfSeriesCorrectly(int input, double output) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly output the sum of the series.";
        runWithInput("" + input, new Clause[][]{{
                new StringLiteral("The sum of the series is: "),
                new DoubleLiteral("sum")
        }});
        assertEquals(Double.parseDouble(getItemByName("sum")), output, 0.0000001, "Your program does not correctly calculate the sum of the series.");
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void printsErrorMessageForInvalidInput(int input, String errorMessage) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print an error message for invalid input.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(errorMessage)
        });
    }
}
