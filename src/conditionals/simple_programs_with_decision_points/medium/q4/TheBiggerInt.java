package conditionals.simple_programs_with_decision_points.medium.q4;

import java.util.Scanner;

/*
Write a program that will take in two numbers a and b, and compute a - b only
if a is greater than b. Note that the first number is a and the second number is b.

Sample Output:
	Enter the first number: 40
	Enter the second number: 20
	a = 20, b = 20

 */

public class TheBiggerInt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a = input.nextInt();
        System.out.println("Enter the second number: ");
        int b = input.nextInt();
        if (a > b)
            a = a - b;
        System.out.println("a = " + a + ", b = " + b);
    }

}
