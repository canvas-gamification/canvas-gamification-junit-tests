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

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "10";
        return new Clause[]{
                new StringLiteral("Enter a number for the upper bound of the series: "),
                new NewLine(),
                new StringLiteral("The sum of the series is: "),
                new DoubleLiteral("sum"),
        };
    }

    public void runMain() {
        DivSeries.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(-1, 0.0),
                Arguments.of(15, 66.36457986457985),
                Arguments.of(456, 134.01609129759674),
                Arguments.of(45646, 226.117957553754)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSumOfSeriesCorrectly(int input, double sum) throws InvalidClauseException {
        runWithInput("" + input);
        assertEquals(Double.parseDouble(getItemByName("sum")), sum, 0.00001, "Your program does not correctly calculate the sum of the series.");
    }
}
