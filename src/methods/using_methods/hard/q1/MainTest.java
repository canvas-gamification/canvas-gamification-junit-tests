package methods.using_methods.hard.q1;

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
        TestOption.defaultInput = "4 2";
        return new Clause[]{
                new StringLiteral("Please enter the first number:"),
                new NewLine(),
                new StringLiteral("Please enter the second number:"),
                new NewLine(),
                new StringLiteral("The first value raised to the second value is: "),
                new DoubleLiteral("power")
        };
    }

    public void runMain() {
        GotThePower.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(Arguments.of(57, 0, 1.0), Arguments.of(2, 4, 16.0), Arguments.of(5, -2, 0.04),
                Arguments.of(1945, 1, 1945.0), Arguments.of(-4, 7, -16384.0), Arguments.of(-6, 4, 1296.0));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(int base, int exponent, double result) {
        runWithInput(String.join(" ", String.valueOf(base), String.valueOf(exponent)));
        assertEquals(Double.parseDouble(getItemByName("power")), result, 0.0000001,
                "Your program does not correctly output the first value raised to the second value.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMathsExpMethod(int base, int exponent, double result) throws Throwable {
        Object[][] arguments = {
                {base, int.class},
                {exponent, int.class}
        };
        MethodTest m = new MethodTest(GotThePower.class, "mathsExp", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(result, output, 0.0000001, "Your mathsExp method does not correctly calculate the first integer raised to the power of the second.");
    }

}
