package conditionals.programs_with_decision_points.hard.q10;

/*
 * Write a Java Program that determines the cost of a dinner considering if the service was good i.e. if the
 * service was good, the user will tip more. If the service was great, then the user tips 20%. If the service
 * is okay, then the user tips 15%. The cost of a dinner should be round to the nearest integer. Make sure to
 * print “Unknown inputs” if the input is invalid.
 * 
 * Sample output:
 *    How much was the food?
 *    100
 *    Was the service great? (Enter 1 for Yes, and 0 for No)
 *    1
 *    For dinner, you will pay 120 dollars.
 * 
 * Distractors:
 *    costOfFood = costOfFood + 1.2;
 *    costOfFood = costOfFood + 1.5;
 *    costOfFood = costOfFood*0.2;
 *    costOfFood = costOfFood*0.15;
 *    String costOfFood = input.nextInt();
 *
 */

import java.util.Scanner;

public class DinnerCost {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("How much was the food?");
      double costOfFood = input.nextDouble();
      System.out.println("Was the service great? (Enter 1 for Yes, and 0 for No)");
      int temp = input.nextInt();
      if ((temp != 1 && temp != 0) || costOfFood < 0) {
         System.out.println("Unknown inputs");
      } else {
         if (temp == 1) {
            costOfFood = costOfFood * 1.2;
         } else
            costOfFood = costOfFood * 1.15;
         System.out.println("For dinner, you will pay " + Math.round(costOfFood) + " dollars.");
      }
   }
}
