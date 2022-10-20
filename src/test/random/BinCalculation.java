package test.random;

import java.util.Random;

public class BinCalculation {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 1; i < 201; i++) {
            System.out.println(r.nextInt(i));
        }
    }
}
