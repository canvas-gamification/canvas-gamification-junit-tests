package arrays.programs_involving_data_sequences.hard.q5;
/*
Write a program that calls a method named findTheLast(int [] array, int target) that takes as input an array of integer
numbers and a target number to search for and return the index of the last matching element in the array. If no match is
identified, return -1. The main method should prompt the user to enter an array of 8 numbers and the target. Then, print
the index returned from the method. Ensure your output matches the sample, and that yur method is general enough to work
with any array length. Assume the user only enters positive integers.

Sample Output:
    Enter 8 numbers:
    1
    2
    2
    3
    4
    5
    7
    3
    Enter a number to search for:
    2
    Returned index:
    2
 */

import java.util.Scanner;

public class FindThatNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[8];
        System.out.println("Enter 8 numbers: ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        System.out.println("Enter a number to search for: ");
        int search = input.nextInt();
        System.out.println("Returned index: ");
        System.out.println(findTheLast(arr, search));
    }

    public static int findTheLast(int[] arr, int num) {
        int ind = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num)
                ind = i;
        return ind;
    }
}
