package test.random.random_method_testing;

import global.MethodTest;
import global.variables.clauses.RandomDouble;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RandomMethodTest {
    // This is an example of how you can use randomDouble to check the randomness of a provided arrayList

    @Test
    public void correctRandomMethod() throws Throwable {
        MethodTest m = new MethodTest(RandomMethod.class, "random");
        ArrayList<Double> values = new ArrayList<>();
        for (int i = 0; i < 1000; i ++) {
            Object output = m.callMethod();
            if(output instanceof Double)
                values.add((Double)output);
            else
                fail("Your random method does not return the correct output.");
        }
        RandomDouble randomDouble = new RandomDouble(0, 100);
        assertTrue(randomDouble.validateRandom(values),
                "Your random method does not correctly return random values between 0 and 100");
    }
}
