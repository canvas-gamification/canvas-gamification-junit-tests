package methods.modular_programs.hard.q6;

/*
Write a Java program that calculates the final bill at a restaurant. The main method asks the user to enter the cost of
the food as a double, and either a 'Y' or 'N' character if the service was great. The double and char should then be
passed to a method called foodCost. If the service was great, then the user tips 20% of the cost of the food. If the
service was okay, the user tips 15%. The method returns the total cost as a double which the main method then prints out.
Assume user input is always valid.

Sample Output:
    Enter the cost of the food:
    120
    Was the service great? (Enter Y/N)
    N
    For dinner, you will pay 138.0 dollars
 */

import java.util.Scanner;

public class DinnerCost {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cost of the food:");
        double costOfFood = input.nextDouble();
        System.out.println("Was the service great? (Enter Y/N)");
        String temp = input.next();
        char service = temp.charAt(0);
        double costAfterTip = foodCost(costOfFood, service);
        System.out.println("For dinner, you will pay " + costAfterTip + " dollars.");
    }

    public static double foodCost(double costOfFood, char service) {
        if (service == 'Y') {
            costOfFood = costOfFood * 1.2;
        } else
            costOfFood = costOfFood * 1.15;
        return costOfFood;
    }
}
