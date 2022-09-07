package methods.modular_programs.hard.q6;

/**
 * Write a Java Program with a method called foodCost that determines the cost
 * of a dinner considering if the service was good i.e. if the service was good,
 * the user will tip more. If the service was great, then the user tips 20%. If
 * the service is okay, then the user tips 15%. It's guaranteed that the input is
 * always valid.
 * 
 * Sample Output:
 *    How much was the food
 *    120
 *    Was the service great? (Enter Y/N)
 *    N
 *    For dinner, you will pay 138.0 dollars
 * 
 */
import java.util.Scanner;

public class DinnerCost {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How much was the food");
    double costOfFood = input.nextDouble();
    System.out.println("Was the service great? (Enter Y/N)");
    String temp = input.next();
    char service = temp.charAt(0);
    double costAfterTip = foodCost(service, costOfFood);
    System.out.println("For dinner, you will pay " + costAfterTip + " dollars.");
  }

  public static double foodCost(char service, double costOfFood) {
    if (service == 'Y') {
      costOfFood = costOfFood * 1.2;
    } else
      costOfFood = costOfFood * 1.15;
    return costOfFood;
  }
}
