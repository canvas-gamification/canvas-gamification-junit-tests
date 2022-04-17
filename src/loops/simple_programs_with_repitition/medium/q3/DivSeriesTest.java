package loops.simple_programs_with_repitition.medium.q3;

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

public class DivSeriesTest extends BaseTest {
    // Parsons

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[] {
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new StringLiteral("The sum of the series is "),
                new DoubleLiteral("numberOutput"),
        };
    }

    public void runMain() {
        DivSeries.main(new String[0]);
    }

    static Stream<Arguments> inputProvider(){
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(15, 66.4),
            Arguments.of(456, 134.0),
            Arguments.of(45646, 226.1)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testWithInput(int input, double output) throws InvalidClauseException {
        runWithInput("" + input);
        assertEquals(Double.parseDouble(getItemByName("numberOutput")), output, 0.1, "Division series sum value is incorrect.");
    }
}
