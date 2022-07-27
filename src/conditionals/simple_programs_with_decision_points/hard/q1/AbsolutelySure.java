package conditionals.simple_programs_with_decision_points.hard.q1;

import java.util.Scanner;

/*
Write a program to display the absolute value of the value entered by the user.
Eg: display 1 if user enters 1, and 1 if the user enters -1.

Distractors:
if( ab >> 0 )
else (ab > 0)
if ab < 0
if( ab < 0 );
else;
System.out.println( - ab );
 */
public class AbsolutelySure
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter a number: ");
        int ab = input.nextInt();
        if( ab < 0 )
            System.out.println( -1 * ab );
        else
            System.out.println( ab );
    }
}
