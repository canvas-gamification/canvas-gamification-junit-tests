package arrays.referencing_array_and_its_elements.hard.q10;

/*
Write a java program called MinFinder. It should have a main method and another method called minFinder. The minFinder
method should accept an array of doubles (double [] arr) and print out its lowest value. The main method should take an
array of doubles (double [] arr) and call the method minFinder with that array as the parameter.

Sample Output:
    Enter an array of 10 double values:
    60.5 50.2 70.2 43.2 61.4 32.5 74.1 11.2 94.3 64.3
    The minimum value of the array is: 11.2
 */

import java.util.Scanner;

public class MinFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        System.out.println("Enter an array of 10 double values:");
        for (int i = 0; i < 10; i++)
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
