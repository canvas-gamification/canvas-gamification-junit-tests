package test;

import java.util.Random;

public class RandomDoubleExponent {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(String.valueOf((r.nextDouble() * 100000000000000.0)));
    }
}
