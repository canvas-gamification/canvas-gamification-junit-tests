package conditionals.programs_with_decision_points.hard.q14;

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
//Parsons
    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "apple\nbanana";
        
        return new Clause[]{
                new StringLiteral("Enter word1:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter word2:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }
    

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                // Test: total length 2+3 = 5 (less than 10)
                Arguments.of("hi", "hey", "Short phrase."),
                // Test: total length 2+7 = 9 (less than 10)
                Arguments.of("hi", "heyyyyy", "Short phrase."),
                // Test: total length 5+5 = 10 (medium)
                Arguments.of("hello", "world", "Medium phrase."),
                // Test: total length 5+6 = 11 (medium)
                Arguments.of("hello", "worldd", "Medium phrase."),
                // Test: total length 5+9 = 14 (medium)
                Arguments.of("hello", "worlddddd", "Medium phrase."),
                // Test: total length 5+11 = 16 (long and word1 does not with lowercase 'a')
                Arguments.of("hello", "worlddddddd", "Long phrase."),
                // Test: total length 8+10 = 18 (long and word1 starts with lowercase 'a')
                Arguments.of("applepie", "watermelon", "a-start long phrase."),
                // Test: total length 6+10 = 16 (long and word1 does not start with 'a')
                Arguments.of("banana", "strawberry", "Long phrase."),
                // Test: total length 9+10 = 19 (long but word1 starts with uppercase 'A')
                Arguments.of("Applejack", "strawberry", "Long phrase.")
        );
    }
    
    @Override
    public void runMain() {
        CheckWord.main(new String[0]);
    }
    
    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectPhrase(String word1, String word2, String expectedPhrase) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct phrase for the entered words.";
        // Simulate user input with the two words (each followed by a newline)
        runWithInput(word1 + "\n" + word2, new Clause[]{
                new StringLiteral(expectedPhrase)
        });
    }
}
