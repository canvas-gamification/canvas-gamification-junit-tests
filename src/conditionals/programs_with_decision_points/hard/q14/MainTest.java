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
    
    @Override
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "apple\nbanana";
        
        return new Clause[]{
                new StringLiteral("Enter word1 "),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter word2 "),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }
    
    /**
     * Provides test cases as (word1, word2, expectedPhrase).<br>
     * The expected outputs are defined according to:
     * <ul>
     *    <li>Combined length < 10: "Short phrase."</li>
     *    <li>Combined length between 10 and 15 (inclusive): "Medium phrase."</li>
     *    <li>Combined length > 15: if word1 starts with lowercase 'a', "a-start long phrase." otherwise "Long phrase."</li>
     * </ul>
     */
    static Stream<Arguments> inputProvider() {
        return Stream.of(
                // Test: total length 2+3 = 5 (less than 10)
                Arguments.of("hi", "hey", "Short phrase."),
                // Test: total length 5+5 = 10 (medium)
                Arguments.of("hello", "world", "Medium phrase."),
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
        checkWord.main(new String[0]);
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
