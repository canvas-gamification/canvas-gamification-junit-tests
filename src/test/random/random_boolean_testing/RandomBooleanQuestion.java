package test.random.random_boolean_testing;

import java.util.Random;

public class RandomBooleanQuestion {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextBoolean());
        System.out.println("Next random value: ");
        System.out.println(r.nextInt(2) == 0 ? "X" : "O");
    }
}
