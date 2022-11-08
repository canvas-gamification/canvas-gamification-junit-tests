package arrays.referencing_array_and_its_elements.hard.q2;
/*
Write a Java program that takes an array of nine numbers from the user and a positive integer x. Then, call a method
named remainder(int[] arr, int x) that takes the array and returns the first n numbers in a new array of length n, where
is the remainder after dividing the array length by x. Print the new array in the main method. Assume the user provides
valid input.

Sample Output:
    Enter nine integers:
    1 5 6 4 ... 2 4 5
    Enter a positive integer:
    7
    The first 2 numbers of the array are:
    1
    5
 */

import java.util.Scanner;

public class Remainder {
    public static void main(String[] args) {
        System.out.println("Enter nine integers:");
        Scanner input = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        System.out.println("Enter a positive integer:");
        int x = input.nextInt();
        int[] remain = remainder(arr, x);
        System.out.println("The first " + (9 % x) + " numbers of the array are:");
        for (int i = 0; i < remain.length; i++)
            System.out.println(remain[i]);
    }

    public static int[] remainder(int[] arr, int x) {
        int n = arr.length % x;
        int[] remainder = new int[n];
        for (int i = 0; i < n; i++)
            remainder[i] = arr[i];
        return remainder;
    }
}
