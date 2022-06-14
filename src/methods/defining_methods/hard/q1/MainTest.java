package methods.defining_methods.hard.q1;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "1.73 65";
        return new Clause[]{
                new StringLiteral("Enter your height in metres:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Enter your weight in kg:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Your BMI is: "),
                new DoubleLiteral("bmi")
        };
    }

    public void runMain() {
        BMIMethodTime.main(new String[0]);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(Arguments.of(1.73, 65, 21.72), Arguments.of(1.45, 78, 37.10),
                Arguments.of(1.85, 52, 15.19), Arguments.of(0.0, 67, 0.00), Arguments.of(1.75, 0, 0.0), Arguments.of(0.0, 0, 0.00));
    }

    static Stream<Arguments> invalidInputProvider() {
        return Stream.of(Arguments.of(-11.69, 76), Arguments.of(1.58, -58),
                Arguments.of(-1.59, -84));
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void worksWithValidInput(double height, int weight, double bmi) {
        runWithInput(String.join(" ", String.valueOf(height), String.valueOf(weight)));
        Object[] obj = invokeIfMethodExists(BMIMethodTime.class, "bmiCalc", new Object[]{height, weight}, double.class, int.class);
        if (!(boolean) obj[0])
            fail("Your program does not have a method for calculating BMI.");
        double result = (double) obj[1];
        assertEquals(result, bmi, 0.01, "Your method does not correctly calculate BMI.");
        assertEquals(Double.parseDouble(getItemByName("bmi")), bmi, 0.001, "Your program does not correctly output BMI.");
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    void worksWithInvalidInput(double height, int weight) {
        runWithInput(String.join(" ", String.valueOf(height), String.valueOf(weight)));
        Object[] obj = invokeIfMethodExists(BMIMethodTime.class, "bmiCalc", new Object[]{height, weight}, double.class, int.class);
        if (!(boolean) obj[0])
            fail("Your program does not have a method for calculating BMI.");
        double result = (double) obj[1];
        assertEquals(result, 0.00, 0.01, "Your method does not handle invalid input.");
        assertEquals(Double.parseDouble(getItemByName("bmi")), 0.00, "Your program does not correctly handle invalid input.");
    }

    public static Object[] invokeIfMethodExists(Class<?> methodClass, String methodName, Object[] arguments, Class<?>... methodArgumentTypes) {
        Object[] obj = new Object[2];
        try {
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            Object result = m.invoke(null, arguments);
            obj[0] = true;
            obj[1] = result;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            obj[0] = false;
            obj[1] = null;
            return obj;
        }
        return obj;
    }

}
