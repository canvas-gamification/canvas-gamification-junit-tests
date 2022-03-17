package conditionals.simple_programs_with_decision_points.medium.q1;
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
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5001";
        return new Clause[]{
                new StringLiteral("What is your investment in \\$ \\(rounded to the nearest dollar\\)\\? "),
                new NewLine(),
                new StringLiteral("Investment : \\$"),
                new IntegerLiteral("investment")
        };
    }

    public void runMain() {
        InvestOp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(5001,10002), Arguments.of(499, 499), Arguments.of(5000, 5000), Arguments.of(8765, 17530));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, int output) throws InvalidClauseException {
        runWithInput(input + "");
        assertEquals(Integer.parseInt(getItemByName("investment")), output, "The calculated investment output is wrong");
    }

}
