package test.random.loggerMethodTestIssue;


import global.MethodTest;
import global.tools.Logger;
import global.variables.clauses.RandomInteger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void correctRandomMethod() throws Throwable{
        MethodTest methodTest = new MethodTest(Generate.class, "randomInt");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int output = (int) methodTest.callMethod();
            numbers.add(output);
            Logger.logMessage("Hello");
        }
        RandomInteger randomInteger = new RandomInteger(0, 50);
        assertTrue(randomInteger.validateRandom(numbers));
    }
}
