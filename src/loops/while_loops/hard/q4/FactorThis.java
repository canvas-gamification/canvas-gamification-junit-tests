package loops.while_loops.hard.q4;
/*
Write a program to ask the user for a number n and print out all of its factors using a while loop. Assume the user
inputs an integer. If the user inputs a number less than 0, the program should print the error message "Invalid input!".

Sample Output:
    Enter a number:
    10
    The factors of 10 are:
    1 2 5 10
 */

import java.util.Scanner;

public class FactorThis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        if (n >= 0) {
            System.out.println("The factors of " + n + " are: ");
            int i = 1;
            while (i <= n) {
                if (n % i == 0)
                    System.out.print(i + " ");
                i++;
            }
        } else {
            System.out.println("Invalid input!");
        }
    }
}
