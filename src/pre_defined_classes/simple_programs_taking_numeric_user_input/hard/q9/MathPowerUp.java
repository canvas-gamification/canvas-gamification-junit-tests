package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q9;

/*
A Math teacher is looking to create a program to teach his students about exponents.
Recall that bnis the same as b multiplied by itself n times.
In this form, b is referred to as the base and n is the exponent.
Make a simple calculator program that asks the user for a base and an exponent, calculates the answer,
 and displays the result.

Sample output:
Enter a base:
2
Enter an exponent:
5
2 to the power of 5 is 32.0

Enter a base:
0
Enter an exponent:
0
0 to the power of 0 is 1.0

Enter a base:
-3
Enter an exponent:
2
-3 to the power of 2 is 9.0

 */

import java.util.Scanner;

public class MathPowerUp {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a base:" );
        int base = input.nextInt();
        System.out.println( "Enter an exponent:" );
        int exponent = input.nextInt();
        double result = Math.pow( base, exponent );
        System.out.print( base + " to the power of " + exponent + " is " + result );
    }

}
