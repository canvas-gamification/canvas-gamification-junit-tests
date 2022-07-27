package loops.programs_with_repetition.medium.q3;
/*
Write a program to ask the user for an integer n and print the following pattern using nested loops where n is the
number of lines. The entered integer should be greater than or equal to 0, and if it is not, the program should print the
error message "Invalid input!". Make sure your output matches the sample.
Sample Output:
    Enter an integer:
    5
    123454321
    1234 4321
    123   321
    12     21
    1       1

 */

import java.util.Scanner;

public class ThisPatternLooksLikePants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = input.nextInt();
        if (n < 0) {
            System.out.println("Invalid input!");
        } else {
            for (int i = 0; i < n; i++) {
                for (int k = 1; k <= n - i; k++)
                    System.out.print(k);
                for (int j = 1; j <= (2 * (i - 1) + 1); j++)
                    System.out.print(" ");
                int o = n - 1 - i;
                if (i > 0)
                    o++;
                for (; o >= 1; o--)
                    System.out.print(o);
                System.out.println();
            }
        }
    }
}
