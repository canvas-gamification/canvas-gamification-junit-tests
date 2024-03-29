package arrays.programs_involving_data_sequences.hard.q8;

/*
Write a Java program that asks the user to enter 100 integers, stores them in an array, and passes that array to a method
called productMaker. This method should take an array of integers and multiply each element by its index. The method
should have no return value as the changes to the array will carry back over to the main method. The main method should
then print the result with a space between each element. The productMaker method should be able to work with an array of
any size. Ex. the array [1,4,6] will become [0,4,12]

Sample Output:
    Enter an array of 100 integers:
    1 2 3 4 5 6 7 8 9 10 ...
    The result of multiplied array is:
    0 2 6 12 20 30 42 56 72 90 ...
 */

import java.util.Scanner;

public class MultItUp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[100];
        System.out.println("Enter an array of 100 integers:");
        for (int i = 0; i < 100; i++)
            arr[i] = in.nextInt();
        productMaker(arr);
        System.out.println("The result of multiplied array is:");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void productMaker(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int value = input[i] * i;
            input[i] = value;
        }
    }
}
