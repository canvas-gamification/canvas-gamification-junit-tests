package arrays.programs_involving_data_sequences.hard.q7;

/*
Write a Java program that asks the user to input 10 integers and stores them in an array. Then it should pass them to a
method called doubler takes an input of an integer array and stores the square of each element in a new array which it
then returns. After calling the method, the main method should print the contents of the new array separated by a space.
Your method should be general enough to work with any size of array.

Sample Output:
    Enter an array of 10 integers to be squared:
    1 2 3 4 5 6 7 8 9 10
    The squared array is:
    1 4 9 16 25 36 49 64 81 100
 */

import java.util.Scanner;

public class SquareUp {
    public static int[] doubler(int[] arr) {
        int[] input = arr.clone();
        for (int i = 0; i < input.length; i++)
            input[i] = (int) Math.pow(input[i], 2);
        return input;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[10];
        System.out.println("Enter an array of 10 integers to be squared:");
        for (int i = 0; i < 10; i++)
            a[i] = in.nextInt();
        a = doubler(a);
        System.out.println("The squared array is:");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
