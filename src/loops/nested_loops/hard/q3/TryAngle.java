package loops.nested_loops.hard.q3;
/*
Write a program to ask the user for n and print the following pattern using nested loops based on their input. Assume
the user inputs an integer.
Sample Output:
    Enter the number of lines:
    n
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
    …
    1 2 3 4 5 … n

 */

import java.util.Scanner;

public class TryAngle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
