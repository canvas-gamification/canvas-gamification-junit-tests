package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q1;

/*
Make a program that takes two integers from the user and displays the answer if you add the first number to the second.

Sample Output:
	Please enter two integers to add:
	2
	3
	The answer is: 5
 */

import java.util.Scanner;

public class ArithmeticStar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter two integers to add: ");
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println("The answer is: " + (x + y));
    }
}
