package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q3;
/*
Make a program that asks the user for two numbers, stores them as variables, prints the numbers, and then swaps the
values of those variables. The program should then print out the swapped variables. Assume the user enters two valid integers.

Sample Output:
	Enter a number: 5
	Enter another number: 25
	Before swapping: x = 5, y = 25
	After swapping: x = 25, y = 5
 */

import java.util.Scanner;

public class SwappingGoodness {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = input.nextInt();
        System.out.println("Enter another number: ");
        int y = input.nextInt();
        System.out.println("Before swapping: x = " + x + ", y = " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("After swapping: x = " + x + ", y = " + y);
    }
}
