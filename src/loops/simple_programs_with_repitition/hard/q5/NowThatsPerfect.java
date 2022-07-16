package loops.simple_programs_with_repitition.hard.q5;

/*
Write a program to accept a number from the user and determine whether it is a "Perfect" number.
(Hint: A perfect number is one whose factors sum up to equal the given number.
Eg. 6 has factors of 1, 2, and 3, whose sum is 6, so it is a perfect number)

Sample Output:
Enter a number:
6
6 is a Perfect Number!

Note: Please add an extra space after the colon in the prompt, and if it is not a perfect output "*number* is NOT a Perfect Number!"
 */

import java.util.Scanner;
public class NowThatsPerfect
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number: " );
        int n = input.nextInt();
        int nn = n;
        int result  = 0;
        int i = 1;
        while( i < n )
        {
            if( n % i == 0 )
                result += i;
            i++;
        }
        if( result == nn )
            System.out.println( nn + " is a Perfect Number!" );
        else
            System.out.println( nn + " is NOT a Perfect Number!" );
    }
}
