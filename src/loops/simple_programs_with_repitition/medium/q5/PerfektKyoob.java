package loops.simple_programs_with_repitition.medium.q5;

/*
Write a program that asks the user for a number and determines if it is a "Perfect Cube", i.e the sum of its digits is equal to its cube root. (Eg: 512 = 8^3 , and 5 + 1 + 2 = 8)
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
	      if(result == (int) Math.pow(nn, 1 / 3.0))
	         System.out.println( nn + " is a Perfect Cube!" );
	      else
	         System.out.println( nn + " is NOT a Perfect Cube!" ); 
	   }
}
