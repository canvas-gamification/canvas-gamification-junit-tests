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

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of("This is first test!", "ThIs iS FiRsT TeSt!"),
            Arguments.of("This is second test", "ThIs iS SeCoNd tEsT"),
            Arguments.of("THIS IS ANOTHER HARDCODED TEST", "ThIs iS AnOtHeR HaRdCoDeD TeSt"),
            Arguments.of(" ", " "));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input, String output) throws InvalidClauseException{
        runWithInput(input, new Clause[] {
            new StringLiteral(output)
        });
    }
}
