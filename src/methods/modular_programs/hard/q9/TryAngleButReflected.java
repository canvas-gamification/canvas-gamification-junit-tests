package methods.modular_programs.hard.q9;

/*
Write a program that asks the user for an integer and passes it to a method called printPattern. The method checks if
the integer is less than 1, if it is it should print "Number must be positive.". Otherwise, it prints the following
pattern using nested loops based on their input:

1 2 3 4 5 … n
…
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

Sample output:
    Enter number of lines:
    3
    1 2 3
    1 2
    1
*/

import java.util.Scanner;

public class TryAngleButReflected {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of lines: ");
        int n = input.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n) {
        if (n <= 0) {
            System.out.println("Input number must be positive.");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
