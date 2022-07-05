package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q8;

/*
Sometimes it's just fun to be able to determine the square root of any given number.
Make a program that asks the user for a numeric value, then determines its square root and prints it out.
Assuming all user inputs are valid, which means that inputs can only be real numbers larger or equal to 0.

Sample output:
    Enter a number:
    4
    The square root value of the given number is:2.0

Sample output:
    Enter a number:
    5
    The square root value of the given number is:2.23606797749979

Sample output:
    Enter a number:
    0
    The square root value of the given number is:0.0

Distractors:
    int inputVal = input.nextDouble();
    double sqrt = inputVal * inputVal;
    double sqrt = inputVal / inputVal;
    int sqrt = Math.sqrt( inputVal );
    System.out.println( "The square root value of the given number is:" + inputVal );
 */

import java.util.Scanner;

public class FeelingSophisticated {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number:" );
        double inputVal = input.nextDouble();
        double sqrt = Math.sqrt( inputVal );
        System.out.println( "The square root value of the given number is:" + sqrt );
    }
}
