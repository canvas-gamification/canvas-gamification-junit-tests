package test;

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
    }
}
