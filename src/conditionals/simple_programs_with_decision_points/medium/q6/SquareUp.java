package conditionals.simple_programs_with_decision_points.medium.q6;
/*
Write a program to take in the measurements of length and width of a rectangle to determine if it is square or not.

Sample Output:
	Enter the length: 5.5
	Enter the width: 6.7
	Just another rectangle…

 */

import java.util.Scanner;
public class SquareUp
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter the length: ");
        double length = input.nextDouble();
        System.out.println("Enter the width: ");
        double width = input.nextDouble();
        if( length ==  width )
            System.out.println("It's a square!");
        else
            System.out.println("Just another rectangle...");
    }
}
