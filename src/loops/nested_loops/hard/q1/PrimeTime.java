package loops.nested_loops.hard.q1;
/*
Write a program that asks the user to input a number n, and then prints all prime numbers from 3 to n (inclusive).
Assume the user provides valid input.
Sample Output:
    Enter a number:
    30
    3 5 7 11 13 17 19 23 29
 */
import java.util.Scanner;

public class PrimeTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        for (int i = 3; i <= n; i++) {
            int c = 0;
            for (int j = 1; j <= i; j++)
                if (i % j == 0)
                    c++;
            if (c == 2)
                System.out.print(i + " ");
        }
    }
}
