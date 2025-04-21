package conditionals.programs_with_decision_points.hard.q15;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    //Java
    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1\n1";
        
        return new Clause[]{
                new StringLiteral("Enter num1:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter num2:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }
    
    static Stream<Arguments> inputProvider() {
        return Stream.of(
            // Test 1: Sum = 10. For example, num1 = 9 and num2 = 1 => 9+1 = 10.
            Arguments.of(9, 1, "Odd-medium sum."),
            // Test 2: Sum between 10 and 19, with num1 even.
            // Example: num1 = 4 and num2 = 7 => 4+7 = 11, 4 is even.
            Arguments.of(4, 7, "Even-medium sum."),
            // Test 3: Sum between 10 and 19, with num1 odd.
            // Example: num1 = 3 and num2 = 8 => 3+8 = 11, 3 is odd.
            Arguments.of(3, 8, "Odd-medium sum."),
            // Test 4: Sum >= 20 and num2 is a multiple of 3.
            // Example: num1 = 10 and num2 = 15 => 10+15 = 25, 15 % 3 == 0.
            Arguments.of(10, 15, "Multiple-of-3 large sum."),
            // Test 5: Sum >= 20 and num2 is not a multiple of 3.
            // Example: num1 = 10 and num2 = 16 => 10+16 = 26, 16 % 3 != 0.
            Arguments.of(10, 9, "Even-medium sum."),
            // Test 6: Sum = 19 with num1 even.
            // Example: num1 = 10 and num2 = 9 => 10+9 = 19, 10 is even.
            // Test 7: Sum = 20, num2 not a multiple of 3 
            Arguments.of(10, 10, "Large sum."),
            // Test 8: Sum = 20, num2 is a multiple of 3 
            Arguments.of(11, 9, "Multiple-of-3 large sum.")
        );
    }
    
    @Override
    public void runMain() {
        Summation.main(new String[0]);
    }
    
    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectClassification(int num1, int num2, String expectedPhrase) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program did not print the correct classification for the sum of the given numbers.";
        // Append newline characters to ensure that both nextInt() calls receive their inputs.
        runWithInput(num1 + "\n" + num2, new Clause[]{
                new StringLiteral(expectedPhrase)
        });
    }
}