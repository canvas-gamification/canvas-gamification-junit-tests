package loops.simple_programs_with_repetition.medium.q4;

/*
Write a Java program to ask the user for a number and calculate the sum of the following series:
1/ n + 2/ n + 3/ n + 4/ n + 5/ n + 6/ n + … (n - 1)/ n. If a negative value is entered, the sum of the series should be 0.

Sample Output:
    Enter a number for the upper bound of the series:
    5
    The sum of the series is 2.0
*/

import java.util.Scanner;

public class SerieslyQuestionMark {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for the upper bound of the series: ");
        double n = input.nextInt();
        double sum = 0;
        for (int i = 1; i < n; i++)
            sum += i / n;
        System.out.println("The sum of the series is " + sum);
    }
}
