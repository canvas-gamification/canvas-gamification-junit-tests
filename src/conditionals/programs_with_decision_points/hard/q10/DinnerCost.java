package conditionals.programs_with_decision_points.hard.q10;

import java.util.Scanner;
public class DinnerCost
{
   public static void main( String [] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println("How much was the food");
      double costOfFood= input.nextDouble();
      System.out.println("Was the service great? (Enter 1 for Yes, and 0 for No)");
      int temp  = input.nextInt();
      if( temp == 1 ) {
         costOfFood = costOfFood*1.2; 
      }
      else 
          costOfFood = costOfFood*1.15;
      System.out.println("For dinner, you will pay " + costOfFood + " dollars.");
   }
}
