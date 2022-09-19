package test;

import java.util.Random;

public class RandomBooleanQuestion {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextBoolean());
        System.out.println(r.nextInt(100) > 98);
        System.out.println(r.nextInt(5) > 0);
    }
}
