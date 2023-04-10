package arrays.arrays_with_methods.hard.q12;

/*
Write a Java program that asks the user to input an array of 10 integers then passes it to a method called
multiplyElements. The method should return a new integer array containing the element stored in the original array
multiplied by the preceding element, with the first element wrapping back around to be multiplied by the last. Ex.
element 2 in the new array is element 2 * element 1 from the original array. The new array should be returned and
printed in the main method. Note: your multiplyElements method should be general enough to work with any array size.

Sample output:
    Enter an array of 10 integers:
    3 8 3 5 1 4 2 6 9 2
    The multiplied elements are:
    6 24 24 15 5 4 8 12 54 18
 */

import java.util.Scanner;

public class ArrayOfMultiples {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an array of 10 integers: ");
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++)
            arr[i] = input.nextInt();
        int[] result = multiplyElements(arr);
        System.out.println("The multiplied elements are: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(result[i] + " ");
    }

    public static int[] multiplyElements(int[] arr) {
        int[] res = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            if (x == 0) {
                res[0] = arr[0] * arr[arr.length - 1];
            } else {
                res[x] = arr[x] * arr[x - 1];
            }
        }
        return res;
    }
}
