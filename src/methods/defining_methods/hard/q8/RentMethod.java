package methods.defining_methods.hard.q8;

/*
Write a Java Program that asks users for the cost of rent for their housing per month. Then write a Java method called
rentCalcYear that accepts that value as a double and returns the cost per year for housing as a double. Your program should
print the returned value in the main method.

Sample Output:
  Enter the cost of rent per month:
  100
  The total cost of rent per year is $1200.0
 */

import java.util.Scanner;

public class RentMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cost of rent per month:");
        double rentCostMonth = input.nextDouble();
        System.out.println("The total cost of rent per year is $" + rentCalcYear(rentCostMonth));
    }

    public static double rentCalcYear(double costPerMonth) {
        return 12 * costPerMonth;
    }
}
