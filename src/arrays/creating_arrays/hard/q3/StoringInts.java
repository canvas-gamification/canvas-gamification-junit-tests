package arrays.creating_arrays.hard.q3;

/*
Write a program that asks the user for one hundred integers, stores those values into an array, and prints the values at
one hundred randomly generated indexes of the array.

Sample output:
    Enter 100 integers:
    374 5 ... 76 -16
    Number at index 2 is: 34
    Number at index 17 is: 5482
    ...
    Number at index 3 is: 76
    Number at index 0 is: 374
 */

import java.util.Scanner;

public class StoringInts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 100 integers: ");
        int[] sent = new int[100];
        for (int i = 0; i < sent.length; i++) {
            sent[i] = input.nextInt();
        }
        for (int i = 0; i < sent.length; i++) {
            int index = (int) (Math.random()*sent.length);
            System.out.println("Number at index " + index + " is: " + sent[index]);
        }
    }
}
