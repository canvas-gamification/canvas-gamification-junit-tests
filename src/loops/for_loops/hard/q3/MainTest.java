package loops.for_loops.hard.q3;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons with distractors
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "5";
        return new Clause[]{
                new StringLiteral("Enter number of terms: "),
                new NewLine(),
                new StringLiteral("Sum of the series = "),
                new DoubleLiteral("sum")
        };
    }

    public void runMain() {
        Seriesly.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(5, 2.283333333333333), Arguments.of(638, 7.036337442577864), Arguments.of(-494, 0.0), Arguments.of(0, 0.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSeriesSumCorrectly(int input, double sum) {
        runWithInput(input + " ");
        assertEquals(Double.parseDouble(getItemByName("sum")), sum, 0.000001, "Your program does not correctly calculate the sum of the series.");
    }
}
