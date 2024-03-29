package methods.modular_programs.easy.q5;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
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
        TestOption.defaultInput = "135.2";
        return new Clause[]{
                new StringLiteral("Please enter your height in cm: "),
                new NewLine(),
                new StringLiteral("Your height in feet is: "),
                new DoubleLiteral("feet")
        };
    }

    public void runMain() {
        HeightInFeet.main(new String[0]);
    }

    static Stream<Arguments> heightConversionInputProvider() {
        return Stream.of(
                Arguments.of(161.5, 5.29855643),
                Arguments.of(88.392, 2.9),
                Arguments.of(182.88, 6.0),
                Arguments.of(0.1, 0.003280839895),
                Arguments.of(-0.1, -1.0),
                Arguments.of(-45, -1.0),
                Arguments.of(0, 0.0),
                Arguments.of(3629, 119.06167979),
                Arguments.of(782541, 25673.91732283));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of(1523, 49.96719),
                Arguments.of(23, 0.754593),
                Arguments.of(174.8264, 5.735774278),
                Arguments.of(-345246.13, -1.0));
    }

    @ParameterizedTest
    @MethodSource("heightConversionInputProvider")
    void correctHeightConversionMethod(double in, double feet) throws Throwable {
        Object[][] arguments = {
                {in, double.class}
        };
        MethodTest m = new MethodTest(HeightInFeet.class, "heightConversion", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(feet, output, 0.00001, "Your heightConversion method does not correctly convert from centimetres to feet.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(double in, double feet) {
        runWithInput(String.valueOf(in));
        assertEquals(feet, Double.parseDouble(getItemByName("feet")), 0.00001, "Your program does not correctly output the height in feet.");
    }
}
