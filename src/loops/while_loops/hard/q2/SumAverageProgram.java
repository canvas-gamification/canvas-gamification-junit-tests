package loops.while_loops.hard.q2;
/*
Write a program that will ask the user for 10 numbers and print their sum and average, using a while loop.

Sample Output:
    Enter a number: 1
 	Enter a number: 2
 	Enter a number: 3
 	Enter a number: 4
 	Enter a number: 5
 	Enter a number: 6
 	Enter a number: 7
 	Enter a number: 8
 	Enter a number: 9
 	Enter a number: 10
 	Sum: 55.0 Average: 5.5
 */

import java.util.Scanner;

public class SumAverageProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        int i = 0;
        while (i < 10) {
            System.out.println("Enter a number:");
            sum += input.nextDouble();
            i++;
        }
        double avg = sum / 10;
        System.out.println("Sum = " + sum + " Average = " + avg);
    }
}
