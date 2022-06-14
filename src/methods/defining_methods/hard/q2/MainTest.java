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
        return Stream.of(Arguments.of(5, 78.54), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(429.83, 580421.27));
    }

    static Stream<Arguments> inputProviderCircumference() {
        return Stream.of(Arguments.of(5, 31.42), Arguments.of(0, 0.0), Arguments.of(-45.96, 0.0),
                Arguments.of(429.83, 2700.70));
    }

    @ParameterizedTest
    @MethodSource("inputProviderArea")
    void calculatesAreaCorrectly(double radius, double area) {
        runWithInput(String.valueOf(radius));
        Object[] results = invokeIfMethodExists(RadOfCircle.class, "areaCalc", new Object[]{radius}, double.class);
        if (!(boolean) results[0])
            fail("Your program does not have a method for calculating the area of a circle.");
        double output = (double) results[1];
        assertEquals(output, area, 0.01, "Your method does not correctly calculate the area of a circle.");
        assertEquals(Double.parseDouble(getItemByName("area")), area, 0.01, "Your program does not correctly output the area of a circle.");
    }

    @ParameterizedTest
    @MethodSource("inputProviderCircumference")
    void calculatesCircumferenceCorrectly(double radius, double circumference) {
        runWithInput(String.valueOf(radius));
        Object[] results = invokeIfMethodExists(RadOfCircle.class, "circCalc", new Object[]{radius}, double.class);
        if (!(boolean) results[0])
            fail("Your program does not have a method for calculating the circumference of a circle.");
        double output = (double) results[1];
        assertEquals(output, circumference, 0.01, "Your method does not correctly calculate the circumference of a circle.");
        assertEquals(Double.parseDouble(getItemByName("circumference")), circumference, 0.01, "Your program does not correctly output the circumference of a circle.");
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
