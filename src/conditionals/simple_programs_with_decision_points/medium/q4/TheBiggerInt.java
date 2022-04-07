package conditionals.simple_programs_with_decision_points.medium.q4;

import java.util.Scanner;

/*
Write a program that will take in two numbers <tt>a</tt> and <tt>b</tt>, and subtract <tt>b</tt> from <tt>a</tt> only
if <tt>a</tt> is greater than <tt>b</tt>.

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
