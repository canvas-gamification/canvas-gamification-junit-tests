package conditionals.programs_with_decision_points.medium.q5;
/*
Write a program that will display a menu to the user and ask the user for their order and how much of the item they
want, and then display the total amount their order would cost based on the following information: $10 for a Pepperoni
Pizza, $15 for Spaghetti Alfredo, $8 for a Panna Cotta, and $3 for a can of soda. If the user enters a number
corresponding to a number on the menu, print “Sorry, we weren't expecting that. Please try again.”. Assume the user
inputs a non-negative integer.

Sample Output:
	Enter the item you would like based on this list:
    1 - Pepperoni Pizza
    2 - Spaghetti Alfredo
    3 - Panna Cotta
    4 - Soda Can
    1
    Enter the quantity of the item you would like to purchase:
    5
    That will cost: $50

 */
import java.util.Scanner;

public class MammaMia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the item you would like based on this list: ");
        System.out.println("1 - Pepperoni Pizza");
        System.out.println("2 - Spaghetti Alfredo");
        System.out.println("3 - Panna Cotta");
        System.out.println("4 - Soda Can");
        int item = input.nextInt();
        System.out.println("Enter the quantity of the item you would like to purchase: ");
        int qty = input.nextInt();
        System.out.print("That will cost: $");
        if (item == 1)
            System.out.print(10 * qty);
        else if (item == 2)
            System.out.print(15 * qty);
        else if (item == 3)
            System.out.print(8 * qty);
        else if (item == 4)
            System.out.print(3 * qty);
        else {
            System.out.println(0);
            System.out.println("Sorry, we weren't expecting that. Please try again.");
        }
    }
}
