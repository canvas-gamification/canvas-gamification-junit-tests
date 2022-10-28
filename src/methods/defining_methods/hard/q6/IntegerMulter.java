package methods.defining_methods.hard.q6;

/*
Write a Java program that asks users for an integer between 0 and 10 (inclusive), which has a method called multiply1000
that takes an integer as an input parameter and returns that integer multiplied by 1000. If the method receives an
invalid integer ( less than 0 or greater than 10), return -1. Call the method with the user input and print the returned
integer in the main method.

Sample Output:
	Enter a number:
	5
	The new number is: 5000
 */

import java.util.Scanner;

public class IntegerMulter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int in = input.nextInt();
        System.out.println("The new number is: " + multiply1000(in));
    }

    public static int multiply1000(int a) {
        if (a >= 0 && a <= 10)
            return a * 1000;
        else
            return -1;
    }
}
