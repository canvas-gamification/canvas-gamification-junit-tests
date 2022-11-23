package arrays.referencing_array_and_its_elements.hard.q8;
/*
Write a program that takes an array of ten integers in ascending order, checks if they are consecutive numbers, and
prints the lowest missing number (if there is one). For example, in an array with elements {2, 3, 5, 6, 7, 10}, the
lowest missing number is 4. To do this, write a method called missingNo that takes an ascending integer array and
returns the lowest missing integer. This method should be generalized to work with any array length. If no integer is
missing, return -1. Print out the number returned by missingNo.

Sample Output:
    Enter 10 integers in ascending order:
    1 2 3 5 6 7 8 9 10 11
    The lowest missing number is: 4
 */

import java.util.Scanner;

public class WhichOneIsNext {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 integers in ascending order:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        System.out.println("The lowest missing number is: " + missingNo(arr));
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
