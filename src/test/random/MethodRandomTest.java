package test.random;

import global.BaseTest;
import global.MethodTest;
import global.tools.Logger;
import global.variables.Clause;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class MethodRandomTest extends BaseTest {
    public Clause[] testSentence() {
        return new Clause[]{
            new RandomInteger(5, 11)
        };
    }

    public void runMain() {
        MethodRandom.main(new String[0]);
    }

    @Test
    public void randomTest() throws Throwable {
        Object[][] args = {
                {5, int.class},
                {11, int.class}
        };
        MethodTest methodTest = new MethodTest(MethodRandom.class, "randomInt", args);
        for (int i = 0; i < 20; i++)
            Logger.logMessage(methodTest.callMethod() + "");
    }

    @Test
    public void reflectionTest() throws Throwable{
        Object[][] args = {
                {5, int.class},
                {11, int.class}
        };
        MethodTest methodTest = new MethodTest(MethodRandom.class, "randomInt", args);
        Object output = methodTest.callMethod();
        Logger.logMessage(Array.getLength(output) + "");
    }

}
