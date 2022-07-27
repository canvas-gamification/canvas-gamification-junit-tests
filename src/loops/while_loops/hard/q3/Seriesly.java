package loops.while_loops.hard.q3;
/*
Write a program that will ask the user for a number n and find the sum of the following series, using a while loop, up
to n terms: 1 + ½ + ⅓ + ¼ + ⅕ + … + 1 / n. Assume the user inputs an integer. If the user does not input a positive
number, the program should print that the sum of the series is 0.

Sample Output:
    Enter number of terms:
    39
    Sum of the series = 4.2535430389363755

Distractors:
    i--;
    while( i <= 10 )
    while( i <= n );
    while  i <= n
    while(int i = 1; i <= n; i--);
    while( i < n )
    while( i < n );
 */

import java.util.Scanner;

public class Seriesly {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of terms: ");
        int n = input.nextInt();
        double sum = 0;
        int i = 1;
        while (i <= n) {
            sum += (double) 1 / i;
            i++;
        }
        System.out.println("Sum of the series = " + sum);
    }
}
