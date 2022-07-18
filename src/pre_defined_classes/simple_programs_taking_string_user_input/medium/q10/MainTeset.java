package pre_defined_classes.simple_programs_taking_string_user_input.medium.q10;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTeset extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "eye";
        return new Clause[]{
                new StringLiteral("Enter your word\\:"),
                new NewLine(),
                new StringLiteral("Is the given word a palindrome\\? "),
                new PlaceHolder()
        };
    }

    public void runMain(){ Palindrome.main(new String[0]);}

    public static Stream<String> palindrome() {

        return Stream.of("LOL", "121", "mom"
                ,"wow", "nun", "eye", "huh"
        );
    }

    public static Stream<String> nonPalindrome() {
        return Stream.of("abc", "123", "MoreThan3Letter");
    }

    @ParameterizedTest
    @MethodSource("palindrome")
    public void identifiesPalindromesCorrectly (String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify palindromes.";
        runWithInput(input, new Clause[]{
                new StringLiteral("true"),
        });
    }

    @ParameterizedTest
    @MethodSource("nonPalindrome")
    public void identifiesNonePalindromesCorrectly (String input) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly identify non-palindromic words.";
        runWithInput(input, new Clause[]{
                new StringLiteral("false"),
        });
    }
}
