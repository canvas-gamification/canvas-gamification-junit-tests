package loops.nested_loops.q5;
/*
Write a program to ask the use for n, and print the following pattern using nested loops based on their input. Assume
the user enters an integer. If the user enters an integer less than 1, the program should not print anything. Make sure
your output matches the sample.
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
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
