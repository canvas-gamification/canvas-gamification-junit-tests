package loops.for_loops.hard.q3;
/*
Write a program that will ask the user for a number n and find the sum of the following series up to n terms using a
for loop: 1 + ½ + ⅓ + ¼ + ⅕ + … + 1 / n . Assume the user provides an integer, and if the integer is less than or equal
to zero, the program should print a sum of 0.

Sample Output:
	Enter number of terms:
    5
    Sum of the series = 2.283333333333333

Distractors:
    for(int i = 1; i >= n; i--)
    for(int i = 1; i <= 10; i++)
    for(int i = 1; i <= n; i++);
    for int i = 1; i <= n; i++
    for(int i = 1; i <= n; i--);
    for(int i = 1, i <= n, i++)

 */

import java.util.Scanner;

public class Seriesly {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of terms: ");
        int n = input.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (double) 1 / i;
        System.out.println("Sum of the series = " + sum);
    }
}
