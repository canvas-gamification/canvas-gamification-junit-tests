package methods.modular_programs.easy.q4;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
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
                new StringLiteral("The values after the decimal point for the first variable are "),
                new DoubleLiteral("first"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the second variable are "),
                new DoubleLiteral("second"),
                new NewLine(),
                new StringLiteral("The values after the decimal point for the third variable are "),
                new DoubleLiteral("third")
        };
    }

    public void runMain() {
        ReturnChange.main(new String[0]);
    }

    static Stream<Arguments> valueAfterCalcInputProvider() {
        return Stream.of(
                Arguments.of(3.1, 0.1),
                Arguments.of(67.2175396, 0.2175396),
                Arguments.of(0.34, 0.34),
                Arguments.of(0.0, 0.0),
                Arguments.of(-12.523, -0.523),
                Arguments.of(0.1, 0.1),
                Arguments.of(-0.1, -0.1));
    }

    @ParameterizedTest
    @MethodSource("valueAfterCalcInputProvider")
    void correctValueAfterCalcMethod(double in, double decimals) throws Throwable {
        Object[][] arguments = {
                {in, double.class}
        };
        MethodTest m = new MethodTest(ReturnChange.class, "valueAfterCalc", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(decimals, output, 0.0000000001, "Your valueAfterCalc method does not correctly extract the numbers after the decimal.");
    }

    @Test
    void printsOutputCorrectly() {
        assertEquals(0.123, Double.parseDouble(getItemByName("first")), 0.00001, "Your program does not correctly display the first number's decimals.");
        assertEquals(-0.24, Double.parseDouble(getItemByName("second")), 0.00001, "Your program does not correctly display the second number's decimals.");
        assertEquals(0.79, Double.parseDouble(getItemByName("third")), 0.00001, "Your program does not correctly display the third number's decimals.");
    }
}
