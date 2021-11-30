package temp;

import java.util.Random;

public class ProphetRobotModified {
    public static void main(String[] args) {
        Random gen = new Random();
        int a = gen.nextInt(2); // Case 1: various random numbers require different ranges
        double b = gen.nextDouble() * 11;
//        double b = gen.nextInt(11);  // Case 2: trying to pass off an int as a double with casting to dodge regex
        int c = gen.nextInt(11);
        System.out.println("A: " + a + " B: " + b + " C: " + c);
    }
}
