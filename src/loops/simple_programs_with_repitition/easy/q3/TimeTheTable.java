package loops.simple_programs_with_repitition.easy.q3;
/*
Write a program that will ask the user for a number and print its multiplication table from 1 to 10.

	Sample output:
	Enter a number:
	5
	5 * 1 = 5
	5 * 2 = 10
	…
	5 * 10 = 50
 */

import java.util.Scanner;
public class TimeTheTable
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number: " );
        int n = input.nextInt();
        for(int i = 1; i <= 10; i++)
            System.out.println( n + " * " + i + " = " + ( n * i ) );
    }
}
