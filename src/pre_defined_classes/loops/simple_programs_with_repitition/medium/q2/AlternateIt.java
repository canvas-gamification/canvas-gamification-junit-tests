package pre_defined_classes.loops.simple_programs_with_repitition.medium.q2;

/*
Write a Java program to ask the user for a number and 
calculate the sum of the following series: 1 - 2 + 3 - 4 + 5 - 6 + … n
*/

import java.util.Scanner;
public class AlternateIt
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number for the upper bound of the series: " );
      int n = input.nextInt(); 
      int sum  = 0; 
      for(int i = 0; i < n; i++) 
         sum += Math.pow( -1, i ) * ( i + 1 );
      System.out.println("The sum of the series is " + sum ); 
   }
}
