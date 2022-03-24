package loops.simple_programs_with_repitition.easy.q5;

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
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "The number of words in the sentence is x words.";

        return new Clause[] {
            new StringLiteral("Enter a sentence: "),
            new NewLine(),
            new StringLiteral("The number of words in the sentence is "),
            new IntegerLiteral("numberOutput"),
            new StringLiteral(" words.")
        };

    }

    public void runMain() {
        WordCount.main(new String[0]);
    }

    public static int countingWords(String message) {
        message.toLowerCase();
        int count = 0;
        for (int i = 0; i < message.length(); i++)
            if (message.charAt(i) == ' ')
                count++;
        return count + 1;
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("This is just for testing. Do not copy!"), Arguments.of("This is second test"), Arguments.of(" ")); // Doesn't work with empty string
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input) throws InvalidClauseException{
        runWithInput(input);
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), countingWords(input), "Calculated value of output is incorrect");
    }

}