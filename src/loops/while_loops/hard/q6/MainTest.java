package loops.while_loops.hard.q6;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "3";
        return new Clause[]{
                new StringLiteral("Enter a number:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() { Factorial.main(new String[0]); }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(0, 0), Arguments.of(10, 3628800), Arguments.of(5, 120), Arguments.of(1, 1), Arguments.of(12, 479001600));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesFactorialCorrectly(int in, int factorial) throws InvalidClauseException {
        Clause[][] place = new Clause[1][3];
        place[0][0] =  new IntegerLiteral("number");
        place[0][1] = new StringLiteral("! = ");
        place[0][2] = new IntegerLiteral("factorial");
        runWithInput(in + System.lineSeparator(), place);
        assertEquals(Integer.parseInt(getItemByName("number")), in, "Your program does not output the input number in the final output.");
        assertEquals(Integer.parseInt(getItemByName("factorial")), factorial, "Your program does not correctly calculate the factorial.");
    }

    @Test
    void printsErrorMessageForInvalidInput() throws InvalidClauseException{
        TestOption.incorrectStructureErrorMessage = "Your program does not identify an invalid input.";
        runWithInput(-6 + System.lineSeparator(), new Clause[]{
                new StringLiteral("Invalid input")
        });
    }
}
