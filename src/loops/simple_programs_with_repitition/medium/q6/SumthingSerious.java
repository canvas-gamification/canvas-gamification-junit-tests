package loops.simple_programs_with_repitition.medium.q6;

/*
Write a Java program to ask the user for a number and calculate the sum of the following series:
1/2 - 2/3 + 3/4 - 4/5 + 5/6 - 6 /7 + … n / n + 1. The program should check to make sure the input is greater than or equal to 0, and
print out "Invalid input!" if it is not. Also, if the number is valid, the program should print out the sum of the series.

Sample Output:
   Enter a number for the upper bound of the series:
   10
   The sum of the series is: 7.980122655122655
*/

import java.util.Scanner;
public class SumthingSerious
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a number for the upper bound of the series: " );
      int n = input.nextInt();
      if(n < 0){
         System.out.println("Invalid input!");
      } else {
         double sum = 0;
         for (double i = 1; i <= n; i++)
            sum += i / (i + 1);
         System.out.println("The sum of the series is: " + sum);
      }
   }
}
