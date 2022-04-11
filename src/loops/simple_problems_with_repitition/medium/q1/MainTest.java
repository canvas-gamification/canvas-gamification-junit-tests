package loops.simple_problems_with_repitition.medium.q1;

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
        TestOption.defaultInput = "10";

        return new Clause[] {
            new StringLiteral("Enter a number : "),
            new NewLine(),
            new IntegerLiteral("numberOutput"),
            new StringLiteral(" in binary is "),
            new PlaceHolder()
        };
    }

    public void runMain() {
        InTheBin.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of(0, ""),
            Arguments.of(1, "1"),
            Arguments.of(345, "101011001"),
            Arguments.of(898468, "11011011010110100100")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, String output) throws InvalidClauseException{
        runWithInput("" + input, new Clause[] {
            new StringLiteral(output)
        });
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), input, "Incorrect binary conversion.");
    }
}
