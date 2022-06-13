package methods.using_methods.hard.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
    void calculatesPowerCorrectly(int base, int exponent, double result) {
        runWithInput(String.join(" ", String.valueOf(base), String.valueOf(exponent)));
        // Check if output is correct
        assertEquals(Double.parseDouble(getItemByName("power")), result, 0.00001,
                "Your program does not correctly output the first value raised to the second value.");
        // Check if method is created and computes the right answer
        try {
            Method m = GotThePower.class.getMethod("mathsExp", int.class, int.class);
            double d = (double) m.invoke(new GotThePower(), new Object[]{
                    base,
                    exponent
            });
            assertEquals(d, result,
                    "Your method does not correctly calculate the first value raised to the second value.");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Your program does not have a method to calculate the first value raised to the second value.");
        }
    }
}
