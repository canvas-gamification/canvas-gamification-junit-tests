package loops.for_loops.hard.q4;
/*
Write a program to ask the user for a number n and print out all of its factors using a for loop. Check to make sure
the user enters a number greater than or equal to 0, and print out "Invalid input!" if it is not.

Sample Output:
	Enter a number:
    10
    Factors of 10 are:
    1 2 5 10
 */

import java.util.Scanner;

public class FactorThis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        if (n >= 0) {
            System.out.println("Factors of " + n + " are: ");
            for (int i = 1; i <= n; i++)
                if (n % i == 0)
                    System.out.print(i + " ");
        } else {
            System.out.println("Invalid input!");
        }
    }
}
