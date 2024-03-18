package arrays.multidimensional_arrays.hard.q3;

/*
Write a Java program that randomly initialize a 3 by 3 multidimensional array, with integers between 1 and 100
(inclusive of both ends) and prints it. Then gets two integers a and b and count the number of odd numbers for all
the integers in the array whose indices are i and j so that 0 <= i < a and 0 <= j < b.

Sample output:
    Generated array:
    42 84 85
    45 50 63
    14 7 17
    Enter two limits for the indices:
    2 3
    count of odd numbers in array = 3
 */

import java.util.Scanner;

public class CountsOdd {
    public static void main(String[] args) {
        System.out.println("Generated array:");
        int[][] arr = new int[3][3];
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[i].length; j ++) {
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two limits for the indices:");
        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                if (arr[i][j] % 2 != 0)
                    count++;
        System.out.println("count of odd numbers in array = " + count);
    }
}
