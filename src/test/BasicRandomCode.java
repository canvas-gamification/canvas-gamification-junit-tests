package test;

import java.util.Random;

public class BasicRandomCode {
    public static void main(String[] args) {
        Random gen = new Random();
        System.out.println("This is a test.");

        int val1 = gen.nextInt(10) - 1000;
        int val2 = gen.nextInt(18);
        int val3 = gen.nextInt(10) + 10;
        int val4 = -gen.nextInt(10) - 10;

        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);

        double dbl1 = gen.nextDouble() * 10 + 5;
        double dbl2 = gen.nextDouble() * -10 - 5;

        System.out.println(dbl1);
        System.out.println(dbl2);
    }
}
