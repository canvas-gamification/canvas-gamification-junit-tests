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

    static double threshold = 5000;
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = String.valueOf(threshold + 1000);
        return new Clause[]{
                new StringLiteral("Enter your investment in \\$ "),
                new NewLine(),
                new PlaceHolder()
            };
    }

    public void runMain() {
        DoubleIt.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(threshold + 1000, "Investment : \\$" + (2 * (threshold + 1000))),
        Arguments.of(threshold - 500, "Investment : \\$" + (threshold - 500)),
        Arguments.of(threshold, "Investment : \\$" + threshold),
        Arguments.of(threshold + 2500.5, "Investment : \\$" + (2 * (threshold + 2500.5)))
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(double investment, String expectedOutput) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct output for the entered investment.";
        runWithInput(String.valueOf(investment), new Clause[]{
            new StringLiteral(expectedOutput)
        });
    }

}