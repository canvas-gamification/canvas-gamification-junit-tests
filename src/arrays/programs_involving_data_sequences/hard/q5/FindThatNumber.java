package arrays.programs_involving_data_sequences.hard.q5;
/*
Write a program that calls a method called findTheLast that takes as input an array of integer numbers and a target
number to search for and returns the index of the last matching element in the array. If no match is found, then the
method returns -1 as output. Then print the value returned from the method.

Write a program that calls a method called findTheLast that takes as input an array of integer numbers and a target
number to search for and returns the index of the last matching element in the array. If no match is found, then the
method returns -1 as output. The main method should prompt the user to enter an array of 8 numbers, and the number to
search for. Then, print the value returned from the method.

 */
import java.util.Scanner;

public class FindThatNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[8];
        System.out.println("Enter 8 numbers: ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        System.out.println("Enter a number to search for: ");
        int search = input.nextInt();
        System.out.println(findTheLast(arr, search));
    }

    public static int findTheLast(int[] arr, int num) {
        int ind = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num)
                ind = i;
        return ind;
    }
}
