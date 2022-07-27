package loops.simple_programs_with_repetition.easy.q8;

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
        TestOption.defaultInput = "This is a sentence. This is another sentence." + System.lineSeparator() + "2";

        return new Clause[] {
            new StringLiteral("Enter a sentence: "),
            new NewLine(),
            new StringLiteral("Enter a number to offset by: "),
            new NewLine(),
            new StringLiteral("Your Encrypted Sentence is: "),
            new PlaceHolder()
        };
        
    }

    public void runMain() {
        CaesarSike.main(new String[0]);
    }

    public static String encrypt(String sentence, int offset) {
        String result = "";
        int i = 0;
        while (i < sentence.length()) {
            result += (char)(sentence.charAt(i) + offset);
            i++;
        }
        return result;
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of("This is just for testing. Do not copy!", 1, encrypt("This is just for testing. Do not copy!", 1)),
            Arguments.of("This is second test", 100, encrypt("This is second test", 100)),
            Arguments.of("hard", 1, "ibse"),
            Arguments.of(" ", 1, "!")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input1, int input2, String output) throws InvalidClauseException{
        runWithInput(input1 + System.lineSeparator() + input2, new Clause[] {
            new StringLiteral(output)
        });
    }
}
