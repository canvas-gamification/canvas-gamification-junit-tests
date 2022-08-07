package loops.simple_programs_with_repetition.hard.q9;

import global.variables.*;
import global.variables.clauses.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

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
                new StringLiteral("Enter a binary number: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        OutTheBin.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(10, 2),
                Arguments.of(101110, 46),
                Arguments.of(1100101, 101),
                Arguments.of(11001001, 201),
                Arguments.of(1011010011, 723)
        );
    }

    static Stream<Integer> invalidInputProvider() {
        return Stream.of(-1, -2, -453, -1010, -11011010, 20000101, 100101007, 10051010, 2);
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void convertsBinaryNumbersToDecimalCorrectly(int input, int output) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly output the conversion from binary to decimal.";
        runWithInput(String.valueOf(input), new Clause[][]{{
                new IntegerLiteral(input, "binaryInput"),
                new StringLiteral(" in base ten is equal to "),
                new IntegerLiteral("decimalConversion")
        }});
        assertEquals(output, Integer.parseInt(getItemByName("decimalConversion")), "Your program does not correctly convert the input number from binary to decimal.");
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void identifiesInvalidNumbersCorrectly(int input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify and print an error message for invalid inputs.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral("Invalid number!")
        });
    }
}
