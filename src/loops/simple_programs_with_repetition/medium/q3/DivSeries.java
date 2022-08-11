package loops.simple_programs_with_repetition.medium.q3;

/*
Write a Java program to ask the user for a number and calculates the sum of the following series:
20/1 + 20/2 + 20/3 + 20/4 + 20/5 + 20/6 + … 20/n. Assume the user enters an integer.

Sample Output:
   Enter a number for the upper bound of the series:
   10
   The sum of the series is: 58.579365079365076
*/

import java.util.Scanner;

public class DivSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for the upper bound of the series: ");
        int n = input.nextInt();
        double sum = 0;
        double i = 1;
        while (i <= n) {
            sum += 20 / i;
            i++;
        }
        System.out.println("The sum of the series is: " + sum);
    }
}
