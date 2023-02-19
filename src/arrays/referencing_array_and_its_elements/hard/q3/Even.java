package arrays.referencing_array_and_its_elements.hard.q3;

/*
Write a Java program that accepts an array of 10 integers from the user and then creates a new array of only even numbers
from the original array. To do this, create a method named even that accepts an integer array, counts the number of even
integers in the array, and then transfer them to a new array of that length in the same order. Note that your method
must be general enough to work with any size of array. Then, return the new array to the main method, and print out its
elements.

Sample Output:
    Enter ten positive integers:
    5 7 6 8 4 1 2 3 10 9
    The array with only even numbers is:
    6 8 4 2 10
 */

import java.util.Scanner;

public class Even {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 positive integers: ");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        int[] evens = even(arr);
        System.out.println("The array with only even numbers is: ");
        for (int i = 0; i < evens.length; i++)
            System.out.print(evens[i] + " ");
    }

    public static int[] even(int[] arr) {
        int numEven = 0;
        for (int i = 0; i < arr.length; i++)
            numEven += arr[i] % 2 == 0 ? 1 : 0;
        int[] evenNumbers = new int[numEven];
        int evenIndices = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0)
                evenNumbers[evenIndices++] = arr[i];
        return evenNumbers;
    }
}
