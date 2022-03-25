package loops.simple_programs_with_repitition.easy.q7;

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
        TestOption.defaultInput = "This is a sentence. This is another sentence.";

        return new Clause[] {
                new StringLiteral("Enter a sentence: "),
                new NewLine(),
                new StringLiteral("YoUr SeNtEnCe In AlTeRnAtInG cAsE iS: "),
                new PlaceHolder()
        };
    }

    public void runMain() {
        AlTeRnAtInGcAsE.main(new String[0]);
    }

    public static String alternate(String sentence) {
        String result = "";
        int i = 0;
        while (i < sentence.length()) {
            if (i % 2 == 0)
                result += Character.toUpperCase(sentence.charAt(i));
            else
                result += Character.toLowerCase(sentence.charAt(i));
            i++;
        }
        return result;
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("This is just for testing. Do not copy!"), Arguments.of("This is second test"), Arguments.of(" ")); // Doesn't work with empty string
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input) throws InvalidClauseException{
        runWithInput(input, new Clause[] {
            new StringLiteral(alternate(input), "stringOutput")
        });
        assertEquals(getItemByName("stringOutput"), alternate(input), "Calculated value of output is incorrect");
    }

}