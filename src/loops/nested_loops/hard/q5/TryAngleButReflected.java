package loops.nested_loops.hard.q5;
/*
Write a program to ask the user for n, and print the following pattern using nested loops based on their input. The
entered integer should be greater than or equal to 0, and if it is not, the program should print the message
“Invalid input!”.
Sample Output:
    Enter the number of lines:
    n
    1 2 3 4 5 … n
    …
    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2
    1

 */

import java.util.Scanner;

public class TryAngleButReflected {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines:");
        int n = input.nextInt();
        if (n < 0) {
            System.out.println("Invalid input!");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= (n - i + 1); j++)
                    System.out.print(j + " ");
                System.out.println();
            }
        }
    }
}
