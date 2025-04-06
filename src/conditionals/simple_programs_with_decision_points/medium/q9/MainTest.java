package conditionals.simple_programs_with_decision_points.medium.q9;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MainTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "6000";
        return new Clause[]{
                new StringLiteral("Enter  your investment in \\$ "),
                new NewLine(),
                new PlaceHolder()
            };
    }

    public void runMain() {
        DoubleIt.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of("6000", "Investment : \\$12000\\.0"),
        Arguments.of("4500", "Investment : \\$4500\\.0"),
        Arguments.of("5000", "Investment : \\$5000\\.0"),
        Arguments.of("7500.50", "Investment : \\$15001\\.0")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(String investment, String expectedOutput) throws InvalidClauseException {
        runWithInput(investment, new Clause[]{
            new StringLiteral(expectedOutput)
        });
    }

}