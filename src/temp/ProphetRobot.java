package temp;

import java.util.Random;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

public class ProphetRobot {
    public static void main(String[] args) {
        Random gen = new Random();
//        int fingersHeldUp = gen.nextInt(2);
        int fingersHeldUp = 10;
        int prediction = gen.nextInt(11);
        boolean same = fingersHeldUp == prediction;
        if (same) {
            System.out.println("The prediction by Simon was: " + prediction + ", and the number of fingers you held up was: " + fingersHeldUp + ". They are the same!");
        }
        else {
            System.out.println("The prediction by Simon was: " + prediction + ", and the number of fingers you held up was: " + fingersHeldUp);
        }
    }
}
