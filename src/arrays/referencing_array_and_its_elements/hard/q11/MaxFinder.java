package arrays.referencing_array_and_its_elements.hard.q11;

/*
Write a java program called MaxFinder. It should have a main method and another method called findMax. The findMax
method should accept an array of doubles (double [] arr) and print out its highest value. The main method should take an
array of doubles (double [] arr) and call the method findMax with that array as the parameter.
Sample Output:
    Enter an array of 10 double values:
    60.5 50.2 70.2 43.2 61.4 32.5 74.1 11.2 94.3 64.3
    The maximum value of the array is: 94.3
 */

import java.util.Scanner;

public class MaxFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] arr = new double[10];
        System.out.println("Enter an array of 10 double values:");
        for (int i = 0; i < 10; i++)
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
