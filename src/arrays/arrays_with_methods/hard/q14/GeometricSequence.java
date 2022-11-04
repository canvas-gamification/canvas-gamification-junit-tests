package arrays.arrays_with_methods.hard.q14;

/*
Write a java program that asks the user for an integer n, then computes and stores the first n terms of a geometric
sequence into an array. A geometric sequence is one of the form s_n = ar^(n - 1), where a is a factor and r is the
common ratio between terms. Your program should contain a method with the method header
public static double[] geometricSequence(int n), which takes an integer and returns the first n terms of the sequence
in an array of doubles. For this question, assume that a = 2 and r = ½. After returning the array, print its values in
the main method.

Sample Output:
    Enter a value for n:
    10
    The first 10 values of the sequence are:
    2.0 1.0 0.5 0.25 0.125 0.0625 0.03125 0.015625 0.0078125 0.00390625
 */

import java.util.Scanner;

public class GeometricSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a value for n: ");
        int n = input.nextInt();
        double[] sequence = geometricSequence(n);
        System.out.println("The first " + n + " values of the sequence are: ");
        for (int i = 0; i < n; i++)
            System.out.print(sequence[i] + " ");
    }

    public static double[] geometricSequence(int n) {
        double a = 2;
        double r = 1.0 / 2.0;
        double[] g = new double[n];
        for (int i = 0; i < n; i++) {
            g[i] = a * Math.pow(r, i);
        }
        return g;
    }
}
