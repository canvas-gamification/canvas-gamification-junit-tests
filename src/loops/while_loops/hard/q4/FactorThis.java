package loops.while_loops.hard.q4;
/*
Write a program to ask the user for a number n and print out all of its factors using a while loop. Assume the user
inputs an integer. If the user does not input a positive number, the program should not output any factors.

Sample Output:
    Enter a number:
    10
    Factors of 10 are :
    1 2 5 10
 */
import java.util.Scanner;

public class FactorThis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        System.out.println("The factors of " + n + " are: ");
        int i = 1;
        while (i <= n) {
            if (n % i == 0)
                System.out.print(i + " ");
            i++;
        }
    }
}
