package temp;

import java.util.Random;
import java.util.Scanner;

/**
 * Simon the prophet claims that he can predict the future. An easy way to test his predictive power is to see whether
 * he can guess correctly how many fingers you are holding up behind your back. Make a Java program that first generates
 * a random number of fingers held up behind a person's back (i.e., a number between 0 and 10 inclusive), and then
 * generates another number that corresponds to Simon's prediction. Then, print out a statement to the console in the
 * following format: "The prediction by Simon was: (prediction value here), and the number of fingers you held up was:
 * (number of fingers held up here)"
 */

public class ProphetRobot {
    public static void main(String[] args) {
        Random gen = new Random();
        double num = -100.998;
        System.out.println(num);
        int prediction = gen.nextInt(10);
        int fingersHeldUp = gen.nextInt(10);
        System.out.println("The prediction by Simon was: " + prediction +
                ", and the number of fingers you held up was: " + fingersHeldUp);
    }
}
