package methods.method_overloading.medium.q2;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons
    final double a = 5.5;
    final int b = 5;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The greater value is: "),
                new DoubleLiteral("max")
        };
    }

    public void runMain() {
        LargerOfVars.main(new String[0]);
    }

    @Test
    void correctlyOverloadedMaxMethod1() {
        String failMessage = "Your program does not have a method which calculates the maximum of a double and integer.";
        double result = (double) invokeIfMethodExists(LargerOfVars.class, "max", failMessage, new Object[]{a, b}, double.class, int.class);
        assertEquals(result, a, 0.001, "Your method does not correctly calculate the maximum of a double and an integer.");
    }

    @Test
    void correctlyOverloadedMaxMethod2() {
        String failMessage = "Your program does not have a method which calculates the maximum of an integer and a double.";
        double result = (double) invokeIfMethodExists(LargerOfVars.class, "max", failMessage, new Object[]{b, a}, int.class, double.class);
        assertEquals(result, a, 0.001, "Your method does not correctly calculate the maximum of an integer and a double.");
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
