package loops.simple_programs_with_repitition.easy.q6;

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
        TestOption.defaultInput = "This is just for testing. Do not copy!" + System.lineSeparator() + "s";

        return new Clause[]{
            new StringLiteral("Enter a sentence: "),
            new NewLine(),
            new StringLiteral("Enter the character to count: "),
            new NewLine(),
            new StringLiteral("The number of times "),
            new PlaceHolder(),
            new StringLiteral(" occurs in the sentence is "),
            new IntegerLiteral("numberOutput"),
            new StringLiteral(" times.")
        };
    }

    public void runMain() {
        CountItUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of("This is just for testing. Do not copy!", "s", 4),
            Arguments.of("This is for second testing. Do not copy!", "o", 5),
            Arguments.of("NNNNNNNN", "n", 0),
            Arguments.of(" ", "z", 0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input1, String input2, int output) throws InvalidClauseException{
        runWithInput(input1 + System.lineSeparator() + input2, new Clause[]{
            new StringLiteral(input2)
        });
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), output, "Number of occurrences is not correct.");
    }
}
