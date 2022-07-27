package loops.programs_with_repetition.medium.q4;

/*
 * Write a program to print an hourglass using the char “*” with nested loops and a positive integer n representing the width of the hourglass.
 * If the user enters a negative integer or 0, the program should print the error message "Invalid Input!".
 *
 * Sample output:
 *    How wide is your hourglass?
 *    5
 *    * * * * *
 *     * * * *
 *      * * *
 *       * *
 *        *
 *       * *
 *      * * *
 *     * * * *
 *    * * * * *
 */

import java.util.Scanner;

public class OurGlass {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("How wide is your hourglass?");
        int n = inp.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input!");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            for (int k = 0; k < n - i; k++)
                System.out.print("* ");
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--)
                System.out.print(" ");
            for (int k = 0; k <= i; k++)
                System.out.print("* ");
            System.out.println();
        }
    }
}
