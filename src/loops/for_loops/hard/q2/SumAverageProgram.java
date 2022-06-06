package loops.for_loops.hard.q2;
/*
Write a program that will ask the user for 10 numbers and print their sum and average. The program should print
“Enter a number:” for each number. Assume the user provides valid input.
Sample Output:
		Enter a number:
		1.2
		Enter a number:
		2.8
		// Repeat until the user enters 10 numbers
		Sum = 10.0 Average = 1.0
 */
import java.util.Scanner;

public class SumAverageProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter a number:");
            sum += input.nextDouble();
        }
        double avg = sum / 10;
        System.out.println("Sum = " + sum + " Average = " + avg);
    }
}
