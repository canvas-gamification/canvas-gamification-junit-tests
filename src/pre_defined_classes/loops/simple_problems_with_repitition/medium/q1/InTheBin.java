package pre_defined_classes.loops.simple_problems_with_repitition.medium.q1;

/*
Write a program to convert a given integer to binary.
 Sample Output:
 Enter a number: 
 5
 5 in binary is 101

 */

import java.util.Scanner;
public class InTheBin
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number : " );
      int n = input.nextInt();
      int nn = n;
      String result = "";
      int rem;
      while( n > 0 ) 
      {
         rem = n % 2;
         result = rem + result;  
         n = n / 2;
      }
      System.out.println( nn + " in binary is " + result );
   }
}
