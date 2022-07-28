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

    static Stream<Arguments> validMethodInputProvider() {
        return Stream.of(Arguments.of(1.73, 65, 21.71806608974573), Arguments.of(1.45, 78, 37.098692033293695),
                Arguments.of(1.85, 52, 15.193571950328705));
    }

    static Stream<Arguments> invalidMethodInputProvider() {
        return Stream.of(Arguments.of(-11.69, 76), Arguments.of(1.58, -58),
                Arguments.of(-1.59, -84), Arguments.of(0.0, 67), Arguments.of(1.75, 0), Arguments.of(0.0, 0));
    }

    static Stream<Arguments> inputProviderOutputTest() {
        return Stream.of(Arguments.of(0.0, 67, 0.00), Arguments.of(1.75, 0, 0.00), Arguments.of(0.0, 0, 0.00),
                Arguments.of(-11.69, 76, 0.00), Arguments.of(1.58, -58, 0.00), Arguments.of(-1.59, -84, 0.00),
                Arguments.of(1.73, 65, 21.72), Arguments.of(1.45, 78, 37.10), Arguments.of(1.85, 52, 15.19));
    }

    @ParameterizedTest
    @MethodSource("validMethodInputProvider")
    void bmiCalcWorksWithValidInput(double height, int weight, double bmi) {
        String failMessage = "Your program does not have a method for calculating BMI.";
        runWithInput(String.join(" ", String.valueOf(height), String.valueOf(weight)));
        double result = (double) invokeIfMethodExists(BMIMethodTime.class, "bmiCalc", failMessage, new Object[]{height, weight}, double.class, int.class);
        assertEquals(result, bmi, 0.000001, "Your bmiCalc method does not correctly calculate BMI.");
    }

    @ParameterizedTest
    @MethodSource("invalidMethodInputProvider")
    void bmiCalcWorksWithInvalidInput(double height, int weight) {
        String failMessage = "Your program does not have a method for calculating BMI.";
        double result = (double) invokeIfMethodExists(BMIMethodTime.class, "bmiCalc", failMessage, new Object[]{height, weight}, double.class, int.class);
        assertEquals(result, 0.00, 0.000001, "Your bmiCalc method does not correctly handle invalid input.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderOutputTest")
    void printsOutputCorrectly(double height, int weight, double bmi) {
        runWithInput(String.join(" ", String.valueOf(height), String.valueOf(weight)));
        assertEquals(Double.parseDouble(getItemByName("bmi")), bmi, 0.001, "Your program does not correctly output BMI.");
    }

    public static Object invokeIfMethodExists(Class<?> methodClass, String methodName, String failMessage, Object[] arguments, Class<?>... methodArgumentTypes) {
        try {
            Method m = methodClass.getMethod(methodName, methodArgumentTypes);
            return m.invoke(null, arguments);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail(failMessage);
            return null;
        }
    }

}
