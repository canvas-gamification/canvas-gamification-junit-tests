package conditionals.programs_with_decision_points.hard.q4Java;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "121";
        return new Clause[]{
                new StringLiteral("Enter an integer:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        MyBestPal.main(new String[0]);
    }

    static Stream<Integer> inputProvider3DigitPalindromes(){
        return Stream.of(121, 333, 565, 999);
    }

    static Stream<Integer> inputProvider3DigitNotPalindromes(){
        return Stream.of(100, 221, 998, 567);
    }

    static Stream<Integer> inputProvider5DigitPalindromes(){
        return Stream.of(12321, 55555, 55655, 74847, 99999);
    }

    static Stream<Integer> inputProvider5DigitNotPalindromes(){
        return Stream.of(12345, 56895, 12724, 55559, 85555, 68976, 10000);
    }

    static Stream<Integer> inputProviderInvalidLengthNumbers(){
        return Stream.of(1, 99, 1000, 100000, 9999, 5614165);
    }

    @ParameterizedTest
    @MethodSource("inputProvider3DigitPalindromes")
    void identifies3DigitPalindromes(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify 3-digit palindromic numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral("number"),
                new StringLiteral(" is a palindrome!")
        });
        assertEquals(Integer.parseInt(getItemByName("number")), number, "Your program does not correctly print out the input number.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider3DigitNotPalindromes")
    void identifies3DigitNonPalindromicNumbers(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify 3-digit non-palindromic numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral("number"),
                new StringLiteral(" is NOT a palindrome!")
        });
        assertEquals(Integer.parseInt(getItemByName("number")), number, "Your program does not correctly print out the input number.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider5DigitPalindromes")
    void identifies5DigitPalindromes(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify 5-digit palindromic numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral("number"),
                new StringLiteral(" is a palindrome!")
        });
        assertEquals(Integer.parseInt(getItemByName("number")), number, "Your program does not correctly print out the input number.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider5DigitNotPalindromes")
    void identifies5DigitNonPalindromicNumbers(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify 5-digit non-palindromic numbers.";
        runWithInput(String.valueOf(number), new Clause[]{
                new IntegerLiteral("number"),
                new StringLiteral(" is NOT a palindrome!")
        });
        assertEquals(Integer.parseInt(getItemByName("number")), number, "Your program does not correctly print out the input number.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderInvalidLengthNumbers")
    void printsErrorMessageForInvalidLengthNumbers(int number) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify invalid inputs.";
        runWithInput(String.valueOf(number), new Clause[]{
                new StringLiteral("Invalid number length!"),
                new Optional(new StringLiteral(""))
        });
    }

}
