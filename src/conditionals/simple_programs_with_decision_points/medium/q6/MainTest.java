package conditionals.simple_programs_with_decision_points.medium.q6;

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

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5.00 5.00";
        return new Clause[]{
                new StringLiteral("Enter the length: "),
                new NewLine(),
                new StringLiteral("Enter the width: "),
                new NewLine(),
                new PlaceHolder()
        };
    }

    public void runMain() {
        SquareUp.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(Arguments.of(5.00, 5.00, "It's a square!"), Arguments.of(4.99, 5.00, "Just another rectangle..."),
                Arguments.of(5.1, 5.0, "Just another rectangle..."));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(double length, double width, String rectangle) throws InvalidClauseException {
        runWithInput(length + System.lineSeparator() + width, new Clause[]{
                new StringLiteral(rectangle)
        });
    }
}
