package arrays.creating_arrays.hard.q1;

/*
Write a Java program that asks the user for the number of elements it will store and uses a method called
createRandomArray() to create a new integer array and initializes the array with random numbers from 0 to the number
that was entered. The main method should then print out the numbers in the array.

Sample output:
    Enter the size of the array:
    5
    Printing out numbers in your array:
    0
    2
    3
    1
    2
 */

import java.util.Scanner;
import java.util.Random;
public class RandomArray{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int arrayLength = input.nextInt();
        int[] myRandomArray = createRandomArray(arrayLength);

        System.out.println("Printing out numbers in your array: ");
        for(int i = 0; i < myRandomArray.length; i++) {
            System.out.println(myRandomArray[i]);
        }
        input.close();
    }

    public static int[] createRandomArray(int arrayLength) {
        Random gen = new Random();
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = gen.nextInt(arrayLength);
        }
        return arr;
    }
}
