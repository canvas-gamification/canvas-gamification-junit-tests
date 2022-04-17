package loops.simple_programs_with_repitition.medium.q7;

/*
Write a Java program to ask the user for a number and 
calculate the sum of the following series: 12 + 22 + 32 + 42 + … n2
*/

import java.util.Scanner;
public class SeriesSeries
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number for the upper bound of the series: " );
      int n = input.nextInt(); 
      int sum  = 0; 
      for(int i = 1; i <= n; i++) 
         sum += i * i;
      System.out.println("The sum of the series is " + sum ); 
   }
}
