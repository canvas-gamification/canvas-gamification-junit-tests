package methods.using_methods.hard.q1;
/*
Write a Java Program that asks the user for two integers. Then, the program will pass those two numbers into a method
called mathsExp that determines the value of the first number raised to the second number and returns that value. The
program should then print this output.
Sample Output:
	Please enter the first number:
    4
    Please enter the second number:
    2
    The first value raised to the second value is: 16.0
 */

import java.util.Scanner;

public class GotThePower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first number:");
        int first = input.nextInt();
        System.out.println("Please enter the second number:");
        int second = input.nextInt();
        System.out.println("The first value raised to the second value is: " + mathsExp(first, second));
    }

    public static double mathsExp(int a, int b) {
        double x = Math.pow(a, b);
        return x;
    }
}
