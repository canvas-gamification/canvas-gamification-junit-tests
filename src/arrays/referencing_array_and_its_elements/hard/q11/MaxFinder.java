package arrays.referencing_array_and_its_elements.hard.q11;

/*
Write a Java program that asks the user to enter 10 double values and stores them in an array. The array should then be
passed to a method called findMax which accepts an array of doubles of any size and finds and returns the largest value in the array
which the main method then prints out.

Sample Output:
    Enter an array of 100 double values:
    60.5 50.2 70.2 43.2 ... 61.4 32.5 74.1 11.2 94.3 64.3
    The maximum value of the array is: 94.3
 */

import java.util.Scanner;

public class MaxFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[100];
        System.out.println("Enter an array of 100 double values:");
        for (int i = 0; i < 100; i++)
            arr[i] = in.nextDouble();
        System.out.println("The maximum value of the array is: " + findMax(arr));
    }

    public static double findMax(double[] arr) {
        double val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > val)
                val = arr[i];
        }
        return val;
    }
}
