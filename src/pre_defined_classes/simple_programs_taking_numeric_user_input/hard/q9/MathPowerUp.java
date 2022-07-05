package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q9;

/*
A Math teacher is looking to create a program to teach his students about exponents.
Recall that b^n is the same as b multiplied by itself n times.
In this form, b is referred to as the base and n is the exponent.
Make a simple calculator program that asks the user for a base and an exponent, calculates the answer,
 and displays the result. Assume both a and b are in decimal form not fraction.

Sample output:
Enter a base:
2
Enter an exponent:
5
2 to the power of 5 is 32.0

Distractors:
    import java.lang.Scanner;
    double base = input.nextInt();
    double exponent = input.nextInt();
    String base = input.next();
    String exponent = input.nextLine();
    double result = Math.pow( exponent, base );
    double result = Math.base( exponent, base );
    double result = Math.exp( base, exponent );
    int result = Math.pow( base, exponent );
    int result = Math.exp( base, exponent );
    int base;
    int exponent;
    int base, exponent, result;
    double base, exponent, result;

 */

import java.util.Scanner;

public class MathPowerUp {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a base:" );
        double base = input.nextDouble();
        System.out.println( "Enter an exponent:" );
        double exponent = input.nextDouble();
        double result = Math.pow( base, exponent );
        System.out.println( base + " to the power of " + exponent + " is " + result );
    }

}
