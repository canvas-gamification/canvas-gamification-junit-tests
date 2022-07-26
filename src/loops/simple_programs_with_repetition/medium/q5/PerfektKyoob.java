package loops.simple_programs_with_repetition.medium.q5;

/*
Write a program that asks the user for a number and determines if it is a "Perfect Cube". In this case, a number is a
perfect cube if the sum of its digits is equal to its cube root. (Eg: 512 = 8^3 , and 5 + 1 + 2 = 8). If the number
is a perfect cube, the program should print "x is a Prefect Cube" and "x is NOT a Perfect Cube!" if not.

Sample Output:
	Enter a number:
	512
	512 is a Perfect Cube!
*/

import java.util.Scanner;
public class PerfektKyoob
{
	   public static void main( String[] args )
	   {
	      Scanner input = new Scanner( System.in );
	      System.out.println( "Enter a number: " );
	      int n = input.nextInt();
	      int nn = n;  
	      int result  = 0; 
	      while( n > 0 )
	      { 
	         result += n % 10 ;
	         n = n / 10;
	      }
	      if(nn == Math.pow(result, 3))
	         System.out.println( nn + " is a Perfect Cube!" );
	      else
	         System.out.println( nn + " is NOT a Perfect Cube!" ); 
	   }
}
