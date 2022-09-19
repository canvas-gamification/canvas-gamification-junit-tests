package arrays.creating_arrays.hard.q3;

/*
Write a program that asks the user for 5 integers, and stores those values into an array and prints the array, with
each value on a new line, back to the user.
Sample output:
Enter 5 integers:
374 5 5482 76 -16
374
5
5482
76
-16
 */

import java.util.Scanner;

public class StoringInts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 integers: ");
        int[] sent = new int[5];
        for (int i = 0; i < sent.length; i++) {
            sent[i] = input.nextInt();
        }
        for (int i = 0; i < sent.length; i++) {
            System.out.println(sent[i]);
        }
    }
}
