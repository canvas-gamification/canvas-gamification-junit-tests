package loops.programs_with_repetition.hard.q1;
/*
Write a program to ask the user for an integer n, and print the following pattern using nested loops, where n is the
starting number and the number of lines. Your program should also make sure the integer is greater than or equal to 0,
and print the error message "Invalid input!" if it is not. Make sure your output matches the sample.
Sample Output:
    Enter an integer:
    5
    55555
    54444
    54333
    54322
    54321

    Enter an integer:
    -1
    Invalid input!
 */

import java.util.Scanner;

public class CascadingPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int length = input.nextInt();
        int n = length;
        if (n < 0) {
            System.out.println("Invalid input!");
        } else {
            for (int i = 0; i < length; i++) {
                for (int j = length; j >= length - i; j--)
                    System.out.print(j);
                for (int k = 1; k < length - i; k++)
                    System.out.print(n);
                System.out.println();
                n--;
            }
        }
    }
}
