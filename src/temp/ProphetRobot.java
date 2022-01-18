package temp;

import java.util.Random;

public class ProphetRobot {
    public static void main(String[] args) {
        Random gen = new Random();
        int prediction = gen.nextInt(100);
        double fingersHeldUp = 6.5 + gen.nextDouble() * 4;
        boolean same = fingersHeldUp == prediction;
        if (same) {
            System.out.println("The prediction by Simon was: " + prediction + ", and the number of fingers you held up was: " + fingersHeldUp + ". They are the same!");
        } else {
            System.out.println("The prediction by Simon was: " + prediction + ", and the number of fingers you held up was: " + fingersHeldUp);
        }

        System.out.println(fingersHeldUp);
    }
}
