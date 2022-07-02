package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q7;

/*
Make a program that asks the user for a score, takes the absolute value of it,
multiplies that by a random number, and displays the product as the user's goal.

Sample output:
Enter your score:
-5
Your goal is 45. Keep up the good work!

 */

import java.util.Random;
import java.util.Scanner;

public class AbsoluteNumber {
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        Random gen = new Random();
        System.out.println( "Enter your score: " );
        int number = in.nextInt();
        number = Math.abs( number );
        number = number * gen.nextInt( 10 );
        System.out.println( "Your goal is " +  number + ". Keep up the good work!" );
    }

}
