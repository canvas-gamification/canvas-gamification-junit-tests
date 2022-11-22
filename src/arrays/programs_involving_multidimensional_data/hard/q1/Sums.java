package arrays.programs_involving_multidimensional_data.hard.q1;

/*
Write a Java program called Sums. It should have a main method which takes user input to create a 4 by 4 2D integer
array and calls another method called sums. The sums method should take a 2D integer array as a parameter and return a
1D integer array which is the sum of each row in the 2D array. The main method should then print the 1D array.

Sample output:
    Enter 4 numbers for row 1:
    3 5 1 2
    Enter 4 numbers for row 2:
    6 5 3 10
    Enter 4 numbers for row 3:
    20 4 1 4
    Enter 4 numbers for row 4:
    7 15 6 2
    11 24 29 30
 */

import java.util.Scanner;

public class Sums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr = new int[4][4];

        for (int x = 0; x < 4; x++) {
            System.out.println("Enter 4 numbers for row " + (x + 1) + ": ");
            for (int y = 0; y < 4; y++) {
                arr[x][y] = input.nextInt();
            }
        }

        int[] sums = sums(arr);

        for (int i = 0; i < sums.length; i++)
            System.out.print(sums[i] + " ");
    }

    public static int[] sums(int[][] arr) {
        int[] sums = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                sums[i] += arr[i][j];
        return sums;
    }
}
