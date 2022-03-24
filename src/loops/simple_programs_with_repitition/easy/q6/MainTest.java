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
            new StringLiteral("StringOutput"),
            new StringLiteral(" occurs in the sentence is "),
            new IntegerLiteral("numberOutput"),
            new StringLiteral(" times.")
        };
    }

    public void runMain() {
        CountItUp.main(new String[0]);
    }

    public static int countingLetter(String message, char c) {
        int count = 0;
        for(int i = 0; i < message.length(); i++) 
            if( message.charAt(i) == c )
                count++;
        return count;
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of("This is just for testing. Do not copy!", "s"), Arguments.of("This is for second testing. Do not copy!", "O"), Arguments.of("AAAAAAaaaaAAaaaa AaaA AA", "a"), Arguments.of(" ", "z"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input1, String input2) throws InvalidClauseException{
        char newInput2 = input2.charAt(0);
        runWithInput(input1 + System.lineSeparator() + input2);
        assertEquals("" + getItemByName("StringOutput"), input2, "Output formatting is incorrect");
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), countingLetter(input1, newInput2), "Calculated value of output is incorrect");
    }
}
