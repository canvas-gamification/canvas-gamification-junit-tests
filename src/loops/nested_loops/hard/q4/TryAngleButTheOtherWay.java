package loops.nested_loops.hard.q4;
/*
Write a program to ask the user for n, and print the following pattern using nested loops based on their input. The input
n should be between 0 and 9 (inclusive). If it is not, the program should print the error message "Invalid input!".
Sample output:
	Enter number of lines:
	n
           1
          21
         321
        4321
    	   …
    n …    1
 */

import java.util.Scanner;

public class TryAngleButTheOtherWay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int n = input.nextInt();
        if (n >= 0 && n <= 9) {
            for (int i = 1; i <= n; i++) {
                for (int j = n - i; j >= 1; j--)
                    System.out.print(" ");
                for (int k = i; k >= 1; k--)
                    System.out.print(k);
                System.out.println();
            }
        } else
            System.out.println("Invalid input!");
    }
}
