package loops.programs_with_repetition.hard.q7;

/*
Write a program called SinOfTheTimes that will take an input x and use it to calculate an approximation of sin(x)
from n = 0 until n = 10 using the following series ( n! symbolises factorials, where n! = n (n - 1)( n - 2 )...(1) ):
x - ( x^3 / 3! ) + ( x^5 / 5! ) - ( x^7 / 7! ) + … + ((-1)^n x^(2n + 1))/( 2n + 1)! Calculate using doubles due to the size limit of integers.

Sample Output:
    Enter a number to approximate:
    3.14
	Approximation of sin(3.14) using n = 10 is …
 */
import java.util.Scanner;

public class SinOfTheTimes
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to approximate: ");
        double x = input.nextDouble();
        double sum = 0;
        for(int n = 0; n <= 10; n++)
        {
            double fact = 1;
            int c = 1;
            while( c <= ( ( 2 * n ) + 1 ) )
            {
                fact *= c;
                c++;
            }
            sum += Math.pow( -1, n ) * ( Math.pow( x, ( ( 2 * n ) + 1 ) ) / fact);
        }
        System.out.println( "Approximation of sin(" + x + ") using n = 10 is " + sum );
    }
}
