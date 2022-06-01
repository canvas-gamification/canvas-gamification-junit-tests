package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q5Java;
/*
A math teacher is looking to create a program to teach her students about square roots. Make a program that asks a user
for an integer and displays its square root as a double. Assume the user enters only enters integers greater than or equal to 0
(non-negative integers). Make sure your output matches the example.

Sample Output:
	Enter a number:
	4
	The square root of 4 is 2.0
 */

import java.util.Scanner;

public class MathSquareRoot {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int num = input.nextInt();
        System.out.println("The square root of " + num + " is " + (Math.sqrt(num)));
    }
}
