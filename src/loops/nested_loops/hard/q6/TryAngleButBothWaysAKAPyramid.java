package loops.nested_loops.hard.q6;

/*
Write a program to ask the use for n ("Enter number of lines: "), and print the following pattern (Pyramid) using nested loops based on their input:
           1
          212
         32123
        4321234
       543212345
         … 1 ...
n …   ...  1 … …  n

 */

import global.exceptions.InvalidClauseException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
public class TryAngleButBothWaysAKAPyramid
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter number of lines: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++)
        {
            for(int j = n - i ; j >= 1; j--)
                System.out.print( " " );
            for(int k = i; k >= 1; k--)
                System.out.print( k );
            for(int l = 2; l <= i; l++)
                System.out.print( l );
            System.out.println();
        }
    }
}
