package methods.modular_programs.easy.q3;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The average of the three integers is "),
                new DoubleLiteral("avg"),
                new NewLine(),
                new StringLiteral("The median of the three integers is "),
                new IntegerLiteral("median")
        };
    }

    public void runMain() {
        MeanNMedian.main(new String[0]);
    }

    static Stream<Arguments> meanCalcInputProvider() {
        return Stream.of(
                Arguments.of(5, 12, 1, 6.0),
                Arguments.of(13, 26, 340, 126.33333333333333),
                Arguments.of(52143, 7045, 41394, 33527.333333333336),
                Arguments.of(-34, 16, -93, -37.0),
                Arguments.of(5, 27, 0, 10.666666666666666));
    }

    static Stream<Arguments> medianCalcInputProvider() {
        return Stream.of(
                Arguments.of(1, 7, 5, 5),
                Arguments.of(10, 3, -2, 3),
                Arguments.of(8, 4, 23, 8),
                Arguments.of(5, 27, 0, 5),
                Arguments.of(-10, -13, 2, -10));
    }

    @ParameterizedTest
    @MethodSource("meanCalcInputProvider")
    void correctAverageCalcMethod(int a, int b, int c, double avg) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(MeanNMedian.class, "meanCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(avg, output, 0.00001, "Your meanCalc method does not correctly calculate the average.");
    }

    @ParameterizedTest
    @MethodSource("medianCalcInputProvider")
    void correctMedianCalcMethod(int a, int b, int c, int median) throws Throwable {
        Object[][] arguments = {
                {a, int.class},
                {b, int.class},
                {c, int.class}
        };
        MethodTest m = new MethodTest(MeanNMedian.class, "medianCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(median, output, "Your medianCalc method does not correctly identify the median.");
    }

    @Test
    void printsOutputCorrectly() {
        assertEquals(13.666666666666666, Double.parseDouble(getItemByName("avg")), 0.00001, "Your program does not correctly print the average.");
        assertEquals(5, Integer.parseInt(getItemByName("median")), "Your program does not correctly print the median.");
    }
}
