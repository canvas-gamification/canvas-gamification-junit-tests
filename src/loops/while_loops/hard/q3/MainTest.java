package loops.while_loops.hard.q3;

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
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "39";
        return new Clause[]{
                new StringLiteral("Enter the number of terms: "),
                new NewLine(),
                new StringLiteral("Sum of the series = "),
                new DoubleLiteral("sum")
        };
    }

    public void runMain() {
        Seriesly.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(39, 4.2535430389363755), Arguments.of(55783, 11.506449070632035), Arguments.of(0, 0.0),
                Arguments.of(-483, 0.0), Arguments.of(1, 1.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void calculatesSumOfSeriesCorrectly(int numTerms, double sum) {
        runWithInput(numTerms + System.lineSeparator());
        assertEquals(Double.parseDouble(getItemByName("sum")), sum, 0.0000000001, "Your program does not correctly calculate the sum of the series up to n terms.");
    }
}
