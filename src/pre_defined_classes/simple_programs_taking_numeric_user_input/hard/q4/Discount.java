package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q4;
/*
A shop is running a 10% discount sale on all products in-store. Make a program that asks for the cost of the groceries,
then applies the discount and displays the cost owing. Assume the user only enters non-negative numbers.

Sample Output:
    Enter the cost of the groceries before the discount: 100
    The discounted cost is $90.0

Distractors:
    {
    }
    Scanner input = new Scanner();
    int initialCost = input.nextDouble();
    double discountCost = initialCost * ((100.0 + 10) / 100.0);
    double discountCost = initialCost * (10.0) / 100.0;
    discountCost = 0.10 * initialCost;
    discountCost = initialCost - discountCost;
    int discountCost;

 */

import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cost of the groceries before the discount: ");
        double initialCost = input.nextDouble();
        double discountCost = initialCost * (1 - 0.10);
        System.out.println("The discounted cost is $" + discountCost);
    }
}
