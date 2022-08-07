package loops.nested_loops.hard.q8;

/*
Write a program called PrimeOrdial that will keep asking users for a number until they
enter a prime number, after which it will break from the loop.
	Sample output:
	Enter a number:
	6
	Enter another number:
	10
	Enter another number:
	5
	Entered a prime number
 */

import java.util.Scanner;
public class PrimeOrdial
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        while( true )
        {
            int c = 0;
            for(int j = 1; j <= n; j++)
                if( n % j == 0 )
                    c++;
            if( c == 2 )
                break;
            System.out.println("Enter another number: ");
            n = input.nextInt();
        }
        System.out.println("Entered a prime number");
    }
}
