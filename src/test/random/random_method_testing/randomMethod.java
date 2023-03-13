package test.random.random_method_testing;

import java.util.Random;

public class randomMethod {
    public static double random() {
        Random random = new Random();
        return random.nextDouble() * 100;
    }
}
