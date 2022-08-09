package loops.while_loops.hard.q7;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.Logger;
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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "slide to the left, take it back now y'all, cha cha real smooth";
        return new Clause[]{
                new StringLiteral("Enter a sentence: "),
                new NewLine(),
                new StringLiteral("Reversed Sentence: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        ReverseSentence.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(" ", " "), Arguments.of("dlrow olleh", "hello world"), Arguments.arguments("Our greatest glory is not in never failing, but in rising up every time we fail.", ".liaf ew emit yreve pu gnisir ni tub ,gniliaf reven ni ton si yrolg tsetaerg ruO"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void reversesSentenceCorrectly(String in, String reverse) throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly reverse the input.";
        Logger.logMessage("Reversing the sentence: " + in + '\n');
        runWithInput(in, new Clause[]{
                new StringLiteral(reverse)
        });
    }
}
