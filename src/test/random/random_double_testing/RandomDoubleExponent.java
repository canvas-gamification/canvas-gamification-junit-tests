package test.random.random_double_testing;

import java.util.Random;

public class RandomDoubleExponent {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println((r.nextDouble() * 100000000000000.0));
        System.out.println(r.nextDouble() / 10000000000.00);
    }
}
