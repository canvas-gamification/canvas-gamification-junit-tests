package conditionals.programs_with_decision_points.hard.q4;

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
        TestOption.defaultInput = "12321";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MyBestPal.main(new String[0]);
    }

    public static Stream<Arguments> inputProviderPalindromes() {
        return Stream.of(Arguments.of(12321, " is a palindrome!"), Arguments.of(999, " is a palindrome!"),
                Arguments.of(99999, " is a palindrome!"), Arguments.of(94849, " is a palindrome!"), Arguments.of(353, " is a palindrome!"));
    }

    public static Stream<Arguments> inputProviderNotPalindromes() {
        return Stream.of(Arguments.of(12345, " is NOT a palindrome!"), Arguments.of(12324, " is NOT a palindrome!"),
                Arguments.of(132, " is NOT a palindrome!"), Arguments.of(877, " is NOT a palindrome!"),
                Arguments.of(45744, " is NOT a palindrome!"), Arguments.of(100, " is NOT a palindrome!"),
                Arguments.of(10000, " is NOT a palindrome!"), Arguments.of(99999, " is a palindrome!"));
    }

    public static Stream<Arguments> inputProviderInvalid() {
        return Stream.of(Arguments.of(1, "Invalid number length!"), Arguments.of(22, "Invalid number length!"),
                Arguments.of(9999, "Invalid number length!"), Arguments.of(123456, "Invalid number length!"),
                Arguments.of(7895987, "Invalid number length!"), Arguments.of(99, "Invalid number length!"),
                Arguments.of(1000, "Invalid number length!"), Arguments.of(100000, "Invalid number length!"));
    }

    @ParameterizedTest
    @MethodSource("inputProviderPalindromes")
    public void worksWithPalindromes(int input, String output) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify palindromic numbers.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(input + output)
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderNotPalindromes")
    public void worksWithNonPalindromicNumbers(int input, String output) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify non-palindromic numbers.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(input + output)
        });
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalid")
    public void worksWithInvalidLengthNumbers(int input, String output) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print an error message for invalid numbers.";
        runWithInput(String.valueOf(input), new Clause[]{
                new StringLiteral(output)
        });
    }
}
