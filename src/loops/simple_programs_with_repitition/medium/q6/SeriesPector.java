package loops.simple_programs_with_repitition.medium.q6;

/*
Write a Java program to ask the user for a number and 
calculate the sum of the following series: 1/2 - 2/3 + 3/4 - 4/5 + 5/6 - 6 /7 + … n / n + 1
*/

import java.util.Scanner;
public class SeriesPector
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number for the upper bound of the series: " );
      int n = input.nextInt(); 
      int sum  = 0; 
      for(int i = 1; i < n; i++) 
         sum += i / ( i + 1 ) ;
      System.out.println("The sum of the series is " + sum ); 
   }
}
