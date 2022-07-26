package methods.defining_methods.medium.q1;

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
                new StringLiteral("The value of the first integer raised to the power of the second integer is: "),
                new DoubleLiteral("power")
        };
    }

    public void runMain() {
        RaiseToPower.main(new String[0]);
    }

    @Test
    void correctPowerCalcMethod() {
        String failMessage = "Your program does not contain a method to calculate the power of one integer raised to another.";
        double result = (double) invokeIfMethodExists(RaiseToPower.class, "powerCalc", failMessage, new Object[]{5, 10}, int.class, int.class);
        assertEquals(result, 9765625.0, 0.0000001,
                "Your method does not correctly calculate the value of one integer raised to the power of another.");
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
