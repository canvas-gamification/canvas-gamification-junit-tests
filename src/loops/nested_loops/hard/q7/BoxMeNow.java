package loops.nested_loops.hard.q7;

/*
Write a program called BoxMeNow to ask the use for n, and print the following pattern using nested loops based on their
input.
Sample Output for n =  4:
Enter number of lines:
4
1111
1  1
1  1
1111

 */

import java.util.Scanner;
public class BoxMeNow
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter number of lines: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if( ( i == 1 || i == n ) || ( j == 1 || j == n ) )
                    System.out.print( "1" );
                else
                    System.out.print( " " );
            }
            System.out.println();
        }
    }
}

