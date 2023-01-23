package arrays.programs_involving_data_sequences.hard.q8;

/*
Write a Java program that calls a method called productMaker that takes as input an array of integers. The method
multiplies each element of the array by the index value and returns that array as output. For example, if the input
array is [1,4,6], then the output array will be [0,4,12]. The program should then print out the resulting array with
each element on a newline. Take an array of size 10 in the main method and give it to the method and print the result
in one line. Your method should be general enough to work with any size of array.

Sample Output:
    Enter an array of 10 integers:
    1 2 3 4 5 6 7 8 9 10
    The result of multiplied array is::
    0 2 6 12 20 30 42 56 72 90
 */

import java.util.Scanner;

public class MultItUp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter an array of 10 integers:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        int[] result = productMaker(arr);
        System.out.println("The result of multiplied array is:");
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }

    public static int[] productMaker(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int value = input[i] * i;
            input[i] = value;
        }
    }
}
