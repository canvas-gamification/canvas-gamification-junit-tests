package conditionals.simple_programs_with_decision_points.medium.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a number: "),
                new NewLine(),
                new StringLiteral("Number = "),
                new IntegerLiteral("numberOutput")
        };
    }

    public void runMain() {
        NumberJumble.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(10, 100), Arguments.of(11, 1), Arguments.of(5, 50), Arguments.of(60, 6));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctOutputNumber(int input, int output) throws InvalidClauseException{
        runWithInput(input + "");
        assertEquals(Integer.parseInt(getItemByName("numberOutput")), output, "The calculated value of output is incorrect.");
    }

}
