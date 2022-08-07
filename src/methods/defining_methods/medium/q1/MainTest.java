package methods.defining_methods.medium.q1;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
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
                new StringLiteral("The value of the first integer raised to the power of the second integer is: "),
                new DoubleLiteral("power")
        };
    }

    public void runMain() {
        RaiseToPower.main(new String[0]);
    }

    static Stream<Arguments> powerCalcInputProvider() {
        return Stream.of(
                Arguments.of(2, 2, 4.0),
                Arguments.of(124, -4, 4.229735977849989E-9),
                Arguments.of(-352, 1, -352.0),
                Arguments.of(348, 3, 42144192)
        );
    }

    @ParameterizedTest
    @MethodSource("powerCalcInputProvider")
    void correctPowerCalcMethod(int base, int exponent, double power) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(RaiseToPower.class, "powerCalc",
                new Object[]{base, exponent}, int.class, int.class);
        CustomAssertions._assertEquals(power, output, 0.00000001, "Your powerCalc method does not correctly calculate the power.");
    }

    @Test
    void printsCorrectOutput() {
        assertEquals(9765625.0, Double.parseDouble(getItemByName("power")), 0.0000001,
                "Your program does not correctly calculate and print the value of one integer raised to the power of another.");
    }
}
