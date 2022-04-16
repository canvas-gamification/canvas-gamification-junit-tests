package methods.modular_programming.hard.q1;
import java.util.Scanner;

/*
Write a program that will ask the user for a number and determine if it is a "right-truncatable prime",
which is a special type of number where after removing each digit from the right, the resulting number
after each digit removal is a prime number.
Eg: 2393 (prime)
239 ( Remove 3, still prime)
23 (remove 9, still prime)
2 (remove 3, still prime)
Create a method with the header public boolean isPrime(int num) to use in the main method.
You may also create other helper methods, though they are not required.
Example Output:
	5
	true
 */

public class RightPrime {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number" );
        int num = input.nextInt();
        System.out.println( isRightPrime(num));
    }
    public static boolean isRightPrime( int num )
    {
        while( num > 0 )
        {
            int factors = 0;
            for( int i = 1; i <= num; i++ )
                if( num % i == 0 )
                    factors++;
            if( factors != 2 )
                return false;
            num /= 10;
        }
        return true;
    }

}
