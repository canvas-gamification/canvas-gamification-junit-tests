package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q7;

/*
Make a program that asks the user for a score between -10 and 10 (both ends included), and takes the absolute value of it.
Then, your program should generate a score modifier (a random number between 1 and 10 inclusive), print it out,
multiply the score by the score modifier, and display the new score to the user.

Sample output:
    Enter your score between -10 and 10 (both ends included):
    -4
    Your score modifier is: 6
    Your goal is 24. Keep up the good work!

 */

import java.util.Random;
import java.util.Scanner;

public class AbsoluteNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        System.out.println("Enter your score between -10 and 10 (both ends included): ");
        int number = in.nextInt();
        number = Math.abs(number);
        int scoreModifier = gen.nextInt(10) + 1;
        System.out.println("Your score modifier is: " + scoreModifier);
        number = number * scoreModifier;
        System.out.println("Your goal is " + number + ". Keep up the good work!");
    }

}
