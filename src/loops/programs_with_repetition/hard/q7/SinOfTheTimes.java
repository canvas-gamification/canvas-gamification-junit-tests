package loops.programs_with_repetition.hard.q7;

/*
Write a program that will calculate an approximation of sin(x) from n = 0 until n = 10, with x = 3.14,
using the following series ( n! symbolises factorials, where n! = n (n - 1)( n - 2 )...(1) ):
x - ( x^3 / 3! ) + ( x^5 / 5! ) - ( x^7 / 7! ) + … + ((-1)^n x^(2n + 1))/( 2n + 1)!
 */

public class SinOfTheTimes
{
    public static void main( String[] args )
    {
        double sum = 0;
        double x = 3.14;
        for(int n = 0; n <= 10; n++)
        {
            int fact = 1;
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
