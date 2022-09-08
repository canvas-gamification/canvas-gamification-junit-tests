package methods.modular_programs.easy.q7;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
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
        TestOption.defaultInput = "5.23 17.95";
        return new Clause[]{
                new StringLiteral("Enter the first number: "),
                new NewLine(),
                new StringLiteral("Enter the second number: "),
                new NewLine(),
                new StringLiteral("The value of the first variable raised to the second variable is "),
                new DoubleLiteral("raised"),
                new NewLine(),
                new StringLiteral("The value of the greater variable converted from degrees to radians is "),
                new DoubleLiteral("radians")
        };
    }

    public void runMain() {
        TwoMethods.main(new String[0]);
    }

    static Stream<Arguments> raisedCalcInputProvider() {
        return Stream.of(
                Arguments.of(2, 4, 16.0),
                Arguments.of(3, 3, 27.0),
                Arguments.of(8.3, 11.2, 1.966412537842738E10),
                Arguments.of(-7.2, 3, -373.24800000000005),
                Arguments.of(-3.6, 4, 167.9616),
                Arguments.of(5.67, -9.6, 5.8291151506320536E-8));
    }

    static Stream<Arguments> degreeCalcInputProvider() {
        return Stream.of(
                Arguments.of(2, 4, 0.06981317007977318),
                Arguments.of(3, 3, 0.05235987755982989),
                Arguments.of(8.3, 11.2, 0.1954768762233649),
                Arguments.of(-7.2, 3, 0.05235987755982989),
                Arguments.of(-3.6, 4, 0.06981317007977318),
                Arguments.of(5.67, -9.6, 0.09896016858807849));
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(Arguments.of("4 5", 1024.0, 0.08726646259971647), Arguments.of("5.7 2.3", 54.76614451050491, 0.09948376736367678), Arguments.of("6.1 -4.7", 2.0368065149446233E-4, 0.1064650843716541));
    }

    @ParameterizedTest
    @MethodSource("raisedCalcInputProvider")
    void correctRaisedCalcMethod(double base, double exponent, double raised) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(TwoMethods.class, "raisedCalc", new Object[]{base, exponent}, double.class, double.class);
        CustomAssertions._assertEquals(raised, output, 0.001, "Your raisedCalc method does not correctly calculate the first variable raised to the second.");
    }

    @ParameterizedTest
    @MethodSource("degreeCalcInputProvider")
    void correctDegreeCalcMethod(double first, double second, double radians) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(TwoMethods.class, "degreeCalc", new Object[]{first, second}, double.class, double.class);
        CustomAssertions._assertEquals(radians, output, 0.001, "Your degreeCalc method does not correctly convert the larger number to radians.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String in, double raised, double radians) {
        runWithInput(in);
        assertEquals(raised, Double.parseDouble(getItemByName("raised")), 0.001, "Your program does not properly display the raised value.");
        assertEquals(radians, Double.parseDouble(getItemByName("radians")), 0.001, "Your program does not properly display the converted radians.");
    }
}
