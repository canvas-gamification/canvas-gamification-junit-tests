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
    void methodsCalculateMaxCorrectly() {
        Object[] results1 = invokeIfMethodExists(LargerOfVars.class, "max", new Object[]{5.5, 5}, double.class, int.class);
        if(!(boolean) results1[0])
            fail("Your program does not have a method which calculates the maximum of a double and integer.");
        double output1 = (double) results1[1];
        assertEquals(output1, 5.5, 0.001, "Your method does not correctly calculate the maximum of a double and an integer.");
        Object[] results2 = invokeIfMethodExists(LargerOfVars.class, "max", new Object[]{5, 5.5}, int.class, double.class);
        if(!(boolean) results2[0])
            fail("Your program does not have a method which calculates the maximum of an integer and a double.");
        double output2 = (double) results2[1];
        assertEquals(output2, 5.5, 0.001, "Your method does not correctly calculate the maximum of an integer and a double.");
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
