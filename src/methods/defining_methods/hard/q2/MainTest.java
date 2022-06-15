package methods.defining_methods.hard.q2;

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
        TestOption.defaultInput = "5.0";
        return new Clause[]{
                new StringLiteral("Enter the radius of the circle:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The area of the circle is:"),
                new Optional(new StringLiteral(" ")),
                new DoubleLiteral("area"),
                new NewLine(),
                new StringLiteral("The circumference of the circle is:"),
                new Optional(new StringLiteral(" ")),
                new DoubleLiteral("circumference")
        };
    }

    public void runMain() {
        RadOfCircle.main(new String[0]);
    }

    static Stream<Arguments> inputProviderArea() {
        return Stream.of(Arguments.of(5, 78.53981633974483), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(429.83, 580421.2715948255));
    }

    static Stream<Arguments> inputProviderCircumference() {
        return Stream.of(Arguments.of(5, 31.41592653589793), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(429.83, 2700.7015405850016));
    }

    static Stream<Arguments> inputProviderOutputTest() {
        return Stream.of(Arguments.of(5, 78.54, 31.42), Arguments.of(0, 0.0, 0.0), Arguments.of(-45.96, 0.0, 0.0),
                Arguments.of(429.83, 580421.27, 2700.70));
    }

    @ParameterizedTest
    @MethodSource("inputProviderArea")
    void correctAreaCalcMethod(double radius, double area) {
        String failMessage = "Your program does not have a method for calculating the area of a circle.";
        double result = (double) invokeIfMethodExists(RadOfCircle.class, "areaCalc", failMessage, new Object[]{radius}, double.class);
        assertEquals(result, area, 0.000001, "Your method does not correctly calculate the area of a circle.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderCircumference")
    void correctCircCalcMethod(double radius, double circumference) {
        String failMessage = "Your program does not have a method for calculating the circumference of a circle.";
        double result = (double) invokeIfMethodExists(RadOfCircle.class, "circCalc", failMessage, new Object[]{radius}, double.class);
        assertEquals(result, circumference, 0.000001, "Your method does not correctly calculate the circumference of a circle.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderOutputTest")
    void printsCorrectOutput(double radius, double area, double circumference) {
        runWithInput(String.valueOf(radius));
        assertEquals(Double.parseDouble(getItemByName("area")), area, 0.01, "Your program does not correctly output the area of a circle.");
        assertEquals(Double.parseDouble(getItemByName("circumference")), circumference, 0.01, "Your program does not correctly output the circumference of a circle.");
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
