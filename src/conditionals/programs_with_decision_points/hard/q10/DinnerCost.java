package conditionals.programs_with_decision_points.hard.q10;

/*
 * Write a Java program that determines the cost of dining at a restaurant depending on the quality of service.
 * The program should prompt the user about the cost of the food and if the service is good. If the service was
 * good, then the user tips 20%. If the service was okay, then the user only tips 15%. The cost of dinner should
 * be rounded to the nearest integer. To decide if the service whether the service is good, the user should enter
 * 1 for Yes, and 0 for No. If the cost of food is less than 0, or the user does not enter 0 or 1 for if the service was good, the program should print "Invalid Input!" to the
 * user.
 * 
 * Sample output:
 *    How much was the food?
 *    100
 *    Was the service good? (Enter 1 for Yes, and 0 for No)
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
      System.out.println("Was the service good? (Enter 1 for Yes, and 0 for No)");
      int temp = input.nextInt();
      if ((temp != 1 && temp != 0) || costOfFood < 0) {
         System.out.println("Invalid Input!");
      } else {
         if (temp == 1) {
            costOfFood = costOfFood * 1.2;
         } else
            costOfFood = costOfFood * 1.15;
         System.out.println("For dinner, you will pay " + Math.round(costOfFood) + " dollars.");
      }
   }
}
