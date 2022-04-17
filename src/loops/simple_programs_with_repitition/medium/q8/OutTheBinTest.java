package loops.simple_programs_with_repitition.medium.q8;

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

public class OutTheBinTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[] {
                new StringLiteral("Enter a binary number : "),
                new NewLine(),
                new StringLiteral("Decimal Number: "),
                new IntegerLiteral("numberOutput"),
        };
    }

    public void runMain() {
        OutTheBin.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(101110, 46),
            Arguments.of(1100101, 101),
            Arguments.of(11001001, 201)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, int output) throws InvalidClauseException {
        runWithInput("" + input);
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), output, "Incorrect decimal conversion.");
    }
}
