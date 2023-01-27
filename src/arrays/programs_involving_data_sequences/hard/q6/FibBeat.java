package arrays.programs_involving_data_sequences.hard.q6;

/*
Recall that the Fibonacci sequence starts with F0 = 0, F1=1, and then all future values are defined by the previous
values using the formula: Fn= Fn-1+Fn-2. Write a Java program that asks the user for an integer n and calls a method
called fibonacciMaker which takes n as an input and generates an array of the first n numbers in the sequence.
The method should return the array and the main method print each element separated by a space. Because the Fibonacci
sequence starts at F0 the size of the array would be n+1. For example, if n is 5, then the method returns the array
[0,1,1,2,3,5]. You can assume that n is always positive. Your method should be general enough to work with any size
of n.

Sample Output:
    Enter a positive integer n:
    5
    The Fibonacci sequence of 5 is:
    0 1 1 2 3 5

 */

import java.util.Scanner;

public class FibBeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer n:");
        int n = in.nextInt();
        int[] arr = fibonacciMaker(n);
        System.out.println("The Fibonacci sequence of " + n + " is:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static int[] fibonacciMaker(int n) {
        int[] out = new int[n + 1];
        out[0] = 0;
        if (n >= 1)
            out[1] = 1;
        if (n >= 2)
            for (int i = 2; i <= n; i++)
                out[i] = out[i - 1] + out[i - 2];
        return out;
    }
}
