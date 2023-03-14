package methods.defining_methods.medium.q2;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
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
                new StringLiteral("The absolute value of the declared variable is: "),
                new DoubleLiteral("absoluteValue")
        };
    }

    public void runMain() {
        AbsoluteMethod.main(new String[0]);
    }

    static Stream<Arguments> absCalcInputProvider() {
        return Stream.of(
                Arguments.of(-541.321584, 541.321584),
                Arguments.of(9856438.21647425545, 9856438.21647425545),
                Arguments.of(0.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("absCalcInputProvider")
    void correctAbsCalcMethod(double input, double absoluteValue) throws Throwable {
        Object[][] arguments = {
                {input, double.class}
        };
        MethodTest m = new MethodTest(AbsoluteMethod.class, "absCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(absoluteValue, output, 0.0000000001,
                "Your method does not correctly calculate the absolute value of a number.");
    }

    @Test
    void printsCorrectOutput() {
        assertEquals(200.56, Double.parseDouble(getItemByName("absoluteValue")), 0.0000000001,
                "Your program does not correctly calculate and print the absolute value of the declared variable.");
    }
}
