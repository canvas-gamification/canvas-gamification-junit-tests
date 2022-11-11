package arrays.referencing_array_and_its_elements.hard.q8;
/*
Write a program that takes an array of ten integers in ascending order. Because we need these numbers to be consecutive
numbers, the program goes through each number one at a time to find the lowest missing number from the sequence.
For example, in an array with elements {2, 3, 5, 6, 7, 10} the lowest missing number is 4. Print out that missing number
if found, or print -1 if there are no missing numbers. For that, write a method called missingNo that takes an ascending
array and return the lowest missing number. Your method should be general enough to work with any size of array.

Sample Output:
    Enter 10 integers in ascending order:
    1 2 3 5 6 7 8 9 10 11
    The lowest missing number is 4
 */

import java.util.Scanner;

public class WhichOneIsNext {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 integers in ascending order:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        System.out.println("The lowest missing number is " + missingNo(arr));
    }

    public static int missingNo(int[] arr) {
        int ans = -1;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] != (arr[i + 1] - 1)) {
                ans = arr[i] + 1;
                break;
            }
        return ans;
    }

}
