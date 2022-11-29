package arrays.referencing_array_and_its_elements.hard.q6;

/*
Write a program that takes an array of ten integers and prints a string containing the first half of the array elements.
To do this, create a method called splitHlaf that takes an integer array and returns the string representation of the
first half of the array. For this program, assume the first half of the array is equal to array.length/2. Note that the
returned string should have spaces between each number and a space at the end. Finally, print the returned string in the
main method. Your method should be general enough to work with any size of an array and any size of an integer.

Sample Output:
    Enter an array of size 10 to split in half:
    3 4 6 21 48 42 89 2 0 91
    The first half of the array is:
    3 4 6 21 48
 */

import java.util.Scanner;

public class RightDownTheMiddle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter an array of size 10 to split in half:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        System.out.println("The first half of the array is:");
        System.out.println(splitHalf(arr));
    }

    public static String splitHalf(int[] inputArray) {
        int size = inputArray.length;
        int[] first = new int[size / 2];
        for (int i = 0; i < size/2; i++) {
                first[i] = inputArray[i];
        }
        String st = "";
        for (int i = 0; i < size / 2; i++)
            st += first[i] + " ";
        return st;
    }
}
