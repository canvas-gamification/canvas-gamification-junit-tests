package loops.while_loops.hard.q6;

/*
Write a program that will accept a non-negative number from the user and print out the factorial of that number.
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

/*
import java.util.Scanner;
public class FactOrIal
{
   public static void main( String[] args )
      {
         Scanner input = new Scanner( System.in );
         System.out.println( "Enter a number: " );
         int n = input.nextInt();
         if(n<0)
	System.out.println(“Invalid input!”);
         else{
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
}
when switching over, you need to change the test to accomodate that there is now two different possible lines and also
need to change question text to include the instruction to say "invalid input" and such
 */

