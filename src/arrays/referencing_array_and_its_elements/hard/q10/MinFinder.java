package arrays.referencing_array_and_its_elements.hard.q10;

/*
Write a Java program to find the smallest number in a double array. The program should prompt the user to enter an array
of 10 doubles and then calls a method named findLow. This method should loop through the numbers in the array and
return the lowest value found. Print the returned value in the main method. Note that your method should be generalized
to work with an array of any length.

Sample Output:
    Enter an array of 100 double values:
    60.5 50.2 70.2 43.2 61.4 32.5 74.1 11.2 94.3 64.3
    The minimum value of the array is: 11.2
 */

import java.util.Scanner;

public class MinFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[100];
        System.out.println("Enter an array of 100 double values:");
        for (int i = 0; i < 100; i++)
            arr[i] = in.nextDouble();
        System.out.println("The minimum value of the array is: " + findLow(arr));
    }

    public static double findLow(double[] arr) {
        double val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < val)
                val = arr[i];
        }
        return val;
    }

}
