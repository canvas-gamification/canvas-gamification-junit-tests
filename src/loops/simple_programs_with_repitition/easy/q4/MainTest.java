package loops.simple_programs_with_repitition.easy.q4;

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
        return new Clause[]{
            new StringLiteral("Enter a number : "),
            new NewLine(),
            new StringLiteral("Reversed Number: "),
            new IntegerLiteral("numberOutput")
        };
    }

    public void runMain() {
        ReverseReverse.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(10, 1), Arguments.of(11, 11), Arguments.of(1776, 6771), Arguments.of(1346000, 6431));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, int output) throws InvalidClauseException{
        runWithInput(input + "");
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), output, "Incorrect reversed value.");
    }

}
