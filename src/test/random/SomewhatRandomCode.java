package test.random;

import java.util.Random;

public class SomewhatRandomCode {
    public static void main(String[] args) {
        Random gen = new Random();
        System.out.println("This is a test.");

        int val1 = gen.nextInt(5);
        int char2 = gen.nextInt(18) + 65;

        System.out.println(val1);
        System.out.println((char) char2);

        double dbl1 = gen.nextDouble() * 10 + 5;

        System.out.println(dbl1);

        int val2 = gen.nextInt(1957) + 49;
        System.out.println(val2);

        double dbl2 = gen.nextDouble() * 1.0311 + 1.567;
        System.out.println(dbl2);

        double dbl3 = gen.nextDouble() * 10000;
        System.out.println(dbl3);

        int val3 = gen.nextInt(27) + 34;
        System.out.println(val3);

        // 1.567, 1.5981

    }
}
