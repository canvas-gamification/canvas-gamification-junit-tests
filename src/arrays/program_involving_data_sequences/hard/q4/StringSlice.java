package arrays.program_involving_data_sequences.hard.q4;
/*
Write a program that calls a method called getRest that takes as input an array of words and an index, then returns a
new array with all the words from that index onwards. The program should then print out all the elements of the returned
array on separate lines.

Write a program that calls a method called getRest that takes as input an array of words and an index, then returns a
new array with all the words from that index onwards. The program should prompt the user to enter 10 words for the array,
and an index, which are sent to the method. Then, print out all the elements of the returned array on separate lines.
Your getRest method should also check of the index is valid, with a valid index being a number greater than 0 and less
than or equal to the length of the array. If the index is invalid, return the input array.
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
        if(index < 0 || index > words.length)
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
