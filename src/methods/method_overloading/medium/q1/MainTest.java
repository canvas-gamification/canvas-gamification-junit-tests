package methods.method_overloading.medium.q1;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest extends BaseTest {
    // Parsons

    final int a = 5;
    final int b = 45;
    final int c = 16;

    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The output of both sum methods is: "),
                new IntegerLiteral("sum1"),
                new StringLiteral(" and "),
                new IntegerLiteral("sum2")
        };
    }

    public void runMain() {
        OverloadSum.main(new String[0]);
    }

    @Test
    void correctTwoIntegerSumMethod() {
        String failMessage = "Your program does not have a method for computing the sum of two integers.";
        int result = (int) invokeIfMethodExists(OverloadSum.class, "sum", failMessage, new Object[]{a, b}, int.class, int.class);
        assertEquals(result, 50, "Your method does not correctly calculate the sum of two integers.");
    }

    @Test
    void correctThreeIntegerSumMethod() {
        String failMessage = "Your program does not have a method for computing the sum of three integers.";
        int result = (int) invokeIfMethodExists(OverloadSum.class, "sum", failMessage, new Object[]{a, b, c}, int.class, int.class, int.class);
        assertEquals(result, 66, "Your method does not correctly calculate the sum of three integers.");
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
