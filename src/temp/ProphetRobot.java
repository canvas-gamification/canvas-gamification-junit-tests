package temp;

import java.util.Random;

public class ProphetRobot {
    public static void main(String[] args) {
        Random gen = new Random();
//        int fingersHeldUp = gen.nextInt(2);
        int fingersHeldUp = 10;
        int prediction = gen.nextInt(11);
//        int prediction = 2;
        System.out.println("The prediction by Simon was: " + prediction + ", and the number of fingers you held up was: " + fingersHeldUp);
    }
}
