package conditionals.programs_with_decision_points.hard.q15;
/*
Write a program that asks the user for two numbers, num1 and num2, less than 50.
Then, determine the sum of both numbers and classify it using switch:
If the sum is less than 10:
Print "Very small sum."
If the sum is between 10 and 19 inclusive:
If num1 is even, print "Even-medium sum."
Otherwise, print "Odd-medium sum."
If the sum is greater than or equal to 20 inclusive:
If num2 is a multiple of 3, print "Multiple-of-3 large sum."
Otherwise, print "Large sum."
 */

import java.util.Scanner;

public class summation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter num1 ");
        int num1 = scanner.nextInt();

        System.out.println("Enter num2 ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;

        switch (sum / 10) {
            case 0:
                System.out.println("Very small sum.");
                break;
            case 1:
                switch (num1 % 2) {
                    case 0:
                        System.out.println("Even-medium sum.");
                        break;
                    case 1:
                        System.out.println("Odd-medium sum.");
                        break;
                }
                break;
            default:
                switch (num2 % 3) {
                    case 0:
                        System.out.println("Multiple-of-3 large sum.");
                        break;
                    default:
                        System.out.println("Large sum.");
                        break;
                }
        }

        scanner.close();
    }
}



