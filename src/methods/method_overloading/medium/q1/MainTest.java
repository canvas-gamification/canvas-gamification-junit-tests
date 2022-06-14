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
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The sum of both integers is: "),
                new IntegerLiteral("sum1"),
                new StringLiteral(" and "),
                new IntegerLiteral("sum2")
        };
    }

    public void runMain() {
        OverloadSum.main(new String[0]);
    }

    @Test
    void methodsCalculateSumCorrectly() {
        Object[] results1 = invokeIfMethodExists(OverloadSum.class, "sum", new Object[]{5, 45}, int.class, int.class);
        if(!(boolean)results1[0])
            fail("Your program does not have a method for computing the sum of two integers.");
        int sum1 = (int)results1[1];
        assertEquals(sum1, 50, "Your method does not correctly calculate the sum of two integers.");
        Object[] results2 = invokeIfMethodExists(OverloadSum.class, "sum", new Object[]{5, 45, 16}, int.class, int.class, int.class);
        if(!(boolean)results2[0])
            fail("Your program does not have a method for computing the sum of three integers.");
        int sum2 = (int)results2[1];
        assertEquals(sum2, 66, "Your method does not correctly calculate the sum of three integers.");
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
