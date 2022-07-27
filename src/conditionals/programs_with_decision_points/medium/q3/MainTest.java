package conditionals.programs_with_decision_points.medium.q3;

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
        TestOption.defaultInput = "3 0 1";
        return new Clause[]{
                new StringLiteral("Enter number 1: "),
                new NewLine(),
                new StringLiteral("Enter number 2: "),
                new NewLine(),
                new StringLiteral("Enter number 3: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        Order.main(new String[0]);
    }

    public static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(1, 2, 3, "1, 2, 3"), Arguments.of(512, 289, 317, "289, 317, 512"),
                Arguments.of(478, 954, 2, "2, 478, 954"), Arguments.of(11, 13, 12, "11, 12, 13"),
                Arguments.of(748, 109878, 1000, "748, 1000, 109878"), Arguments.of(0, 0, 0, "0, 0, 0"),
                Arguments.of(14, -357, -358, "-358, -357, 14"), Arguments.of(0, -300, -200, "-300, -200, 0"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void printNumbersInAscendingOrder(int n1, int n2, int n3, String output) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the integers in ascending order.";
        runWithInput(n1 + " " + n2 + " " + n3, new Clause[]{
                new StringLiteral(output)
        });
    }
}
