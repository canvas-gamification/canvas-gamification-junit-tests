package loops.simple_programs_with_repetition.medium.q7;

/*
Write a Java program to ask the user for a number (as an integer) and calculates the sum of the following series:
1^2 + 2^2 + 3^2 + 4^2 + … n^2. The program should print the sum of the series as a double. If the program receives an input less
than 0, it should print the error message "Invalid input!".

Sample Output:
    Enter a number for the upper bound of the series:
    39
    The sum of the series is: 20540.0
*/

import java.util.Scanner;

public class SeriesSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for the upper bound of the series: ");
        int n = input.nextInt();
        if (n < 0) {
            System.out.println("Invalid input!");
        } else {
            double sum = 0;
            for (int i = 1; i <= n; i++)
                sum += i * i;
            System.out.println("The sum of the series is: " + sum);
        }
    }
}
