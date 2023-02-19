package arrays.creating_arrays.hard.q2;

/*
Write a program asking the user for ten numbers and stores them in an integer array. Then use a method called reverse
which takes an integer array as input and returns the array with its elements reversed. For example, if the user enters
432 as the 5th number, then the 5th array element will be 234. The method should be generalized to handle any size of
array. Assume only positive numbers will be input.

Sample output:
    Enter 10 numbers to add to the array:
    1 12 ... 29 50
    The numbers in the array are:
    1
    21
    ...
    92
    5
 */

import java.util.Scanner;

public class RevdArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers to add to the array: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextInt();
        }
        reverse(arr);
        System.out.println("The numbers in the array are: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static int[] reverse(int[] num) {
        for (int x = 0; x < num.length; x++) {
            int n = num[x];
            int reversed = 0;
            while (n > 0) {
                reversed = (reversed * 10) + n % 10;
                n = n / 10;
            }
            num[x] = reversed;
        }
        return num;
    }
}
