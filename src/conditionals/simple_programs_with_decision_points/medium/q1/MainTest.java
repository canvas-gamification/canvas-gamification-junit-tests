package conditionals.simple_programs_with_decision_points.medium.q1;
import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = joinInputs("5001", "499", "5000", "8765");
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

    static Stream<String> inputProvider() {
        return Stream.of("5001", "499", "5000", "8765");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String input) throws InvalidClauseException {
        runWithInput(input);
        int investmentOutput = Integer.parseInt(input);
        if(investmentOutput > 5000)
            investmentOutput *= 2;
        assertEquals(Integer.parseInt(getItemByName("investment")), investmentOutput, "The calculated investment output is wrong");
    }

    // Helper method
    public static String joinInputs(String... inputs) {
        StringBuilder sb = new StringBuilder();
        for (String input : inputs) {
            sb.append(input).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
