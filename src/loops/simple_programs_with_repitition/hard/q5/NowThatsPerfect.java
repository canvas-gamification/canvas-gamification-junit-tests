package loops.simple_programs_with_repitition.hard.q5;

/*
Write a program with the class name "NowThatsPerfect" to accept a number from the user and determine whether it is a "Perfect" number.
If it is a perfect number print: "x is a Perfect Number!" otherwise print: "x is NOT a Perfect Number!".
A perfect number is one whose factors sum up to equal the given number.
Eg. 6 has factors of 1, 2, and 3, whose sum is 6, so it is a perfect number.

Sample Output:
Enter a number:
5
5 is NOT a Perfect Number!
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
        int result  = -1;
        int i = 1;
        while( i < n )
        {
            if(i == 1)
                result = 0;
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
