package methods.defining_methods.medium.q2;

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
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The absolute value of the declared variable is: "),
                new DoubleLiteral("absoluteValue")
        };
    }

    public void runMain() {
        AbsoluteMethod.main(new String[0]);
    }

    @Test
    void correctAbsCalcMethod() {
        String failMessage = "Your program does not have a method for calculating the absolute value of an input number.";
        double result = (double) invokeIfMethodExists(AbsoluteMethod.class, "absCalc", failMessage, new Object[]{-200.56}, double.class);
        assertEquals(result, 200.56, 0.00000001, "Your method does not correctly calculate the absolute value of a number.");
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
