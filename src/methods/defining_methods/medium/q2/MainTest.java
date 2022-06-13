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
    void calculatesAbsoluteValueCorrectly() {
        try {
            Method m = AbsoluteMethod.class.getMethod("absCalc", double.class);
            double absolute = (double) m.invoke(new AbsoluteMethod(), new Object[]{-200.56});
            assertEquals(absolute, 200.56, 0.00000001,
                    "Your method does not correctly calculate the absolute value of a number.");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Your program does not have a method for calculating the absolute value of an input number.");
        }
    }
}
