package arrays.creating_arrays.hard.q2;

/*
Write a program asking the user for 500 numbers and stores them in an integer array. Then use a method called reverse
which takes an integer as input and returns the integer reversed and store the reversed integer in a new array. For
example, if the user enters 432 as the 5th number, then the 5th array element in the new array will be 234. Assume only
positive numbers will be input.

Sample output:
    Enter 500 numbers to add to the array:
    1 12 ... 29 50
    The numbers in the reversed array are:
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
        int[] arr = new int[500];
        System.out.println("Enter 500 numbers to add to the array: ");
        for (int i = 0; i < 500; i++) {
            arr[i] = reverse(input.nextInt());
        }
        System.out.println("The numbers in the reversed array are: ");
        for (int j : arr) System.out.println(j);
    }

    public static int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = (reversed * 10) + num % 10;
            num = num / 10;
        }
        return reversed;
    }
}
