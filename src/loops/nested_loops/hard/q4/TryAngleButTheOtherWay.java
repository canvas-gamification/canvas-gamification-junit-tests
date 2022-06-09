package loops.nested_loops.hard.q4;
/*
Write a program to ask the use for n, and prints the following pattern using nested loops based on their input. Assume
the user provides valid integer input between 1 and 9 (inclusive).
Sample output:
	Enter number of lines:
	4
           1
          21
         321
        4321
    	   …
    n …    1
 */
import java.util.Scanner;

public class TryAngleButTheOtherWay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j >= 1; j--)
                System.out.print(" ");
            for (int k = i; k >= 1; k--)
                System.out.print(k);
            System.out.println();
        }
    }
}

