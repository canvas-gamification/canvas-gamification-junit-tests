package temp;

import java.util.Random;

public class ProphetRobot {
    public static void main(String[] args) {
        Random gen = new Random();
        int prediction = gen.nextInt(100);
        char fingersHeldUp = (char) (65 + gen.nextInt(5));
        double num = 12 + gen.nextDouble() * 50;
        boolean same = fingersHeldUp == prediction;
        System.out.println("The prediction by Simon was: " + prediction + ", num: " + num + " and the number of fingers you held up was: " + fingersHeldUp);
//        if (same) {
//            System.out.println("The prediction by Simon was: " + prediction + ", num: " + num + " and the number of fingers you held up was: " + fingersHeldUp + ". They are the same!");
//        } else {
//            System.out.println("The prediction by Simon was: " + prediction + ", num: " + num + " and the number of fingers you held up was: " + fingersHeldUp);
//        }

        System.out.println(prediction);
        // TODO: test still passes if this part isn't in the format
    }
}
