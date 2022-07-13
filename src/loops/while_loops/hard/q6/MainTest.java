package loops.while_loops.hard.q6;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    //Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new IntegerLiteral("number"),
                new StringLiteral("! = "),
                new IntegerLiteral("factorial")
        };
    }

    public void runMain() { FactOrIal.main(new String[0]); }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(0, 0), Arguments.of(10, 3628800), Arguments.of(5, 120), Arguments.of(1, 1), Arguments.of(12, 479001600));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesFactorialCorrectly(int in, int factorial){
        runWithInput(in + System.lineSeparator());
        assertEquals(Integer.parseInt(getItemByName("number")), in, "Your program does not output the same number that was input");
        assertEquals(Integer.parseInt(getItemByName("factorial")), factorial, "Your program does not correctly calculate the factorial");
    }
}