package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q7;

/*
A Math teacher is looking to create a program to teach her students about odd and even numbers.
Make a program that asks the user for a number and determines if that number has a remainder after dividing it by 2.

Sample output:
    Enter an integer:
    78
    The remainder value is: 0

Distractors:
    double number = input.nextInt();
    int remainder = number !% 2;
    char remainder = number % 2;
    String remainder = number % 2;
    int remainder = number == 2;
 */

import java.util.Scanner;

public class OddOrEven {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter an integer:" );
        int number = input.nextInt();
        int remainder = number % 2;
        System.out.println( "The remainder value is: " + remainder );
    }

}
