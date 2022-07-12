package loops.while_loops.hard.q6;

/*
Write a program that will accept a number from the user and print out the factorial of that number.
Do so by using a while loop. ( Hint: n factorial or n! = n x (n - 1) x (n - 2) x … x 2 x 1 )
 */
import java.util.Scanner;
public class FactOrIal
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number: " );
        int n = input.nextInt();
        int n2 = n;
        int i = n - 1;
        while( i > 0 )
        {
            n *= i;
            i--;
        }
        System.out.println( n2 + "! = " + n );
    }
}

