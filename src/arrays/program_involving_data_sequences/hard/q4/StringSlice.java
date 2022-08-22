package arrays.program_involving_data_sequences.hard.q4;
/*
Write a program that calls a method named getRest(String[] words, int index) that takes as input an array of strings
and an index. The getRest method should return a new string array containing the strings from the original array
starting from the index (inclusive). Your getRest method should also check if the index is valid, with a valid index
being a number greater than or equal to 0 and less than the length of the array. If the index is invalid, return the
input array.

The main method should prompt the user to enter 10 words (no spaces) for the array and an index and use them to call
getRest. Then, print out all the elements of the returned array on separate lines. Ensure that your output matches the
sample.

Sample Output:
    Enter words for the array:
    lemon
    grape
    lamp
    slot
    ape
    slither
    tame
    game
    computer
    tree
    Enter an index:
    5
    slither
    tame
    game
    computer
    tree

 */

import java.util.Scanner;

public class StringSlice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter words for the array: ");
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.next();
        System.out.println("Enter an index: ");
        int index = input.nextInt();
        String[] result = getRest(arr, index);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static String[] getRest(String[] words, int index) {
        if (index < 0 || index >= words.length)
            return words;
        String[] remaining = new String[words.length - index];
        int pos = 0;
        for (int i = index; i < words.length; i++) {
            remaining[pos] = words[i];
            pos++;
        }
        return remaining;
    }
}
