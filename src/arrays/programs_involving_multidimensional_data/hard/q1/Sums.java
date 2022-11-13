package arrays.programs_involving_multidimensional_data.hard.q1;

/*
Write a Java program called Sums. It should have a main method which takes user input to create a 2D array and calls
another method called sums. The sums method should take a 2D array as a parameter and return a 1D array that is the sum
of each row in the 2D array. The main method should then print the 1D array.

Sample output:
    Enter the number of rows:
    2
    Enter the number of columns:
    3
    Enter the number for row 1 column 1:
    2
    Enter the number for row 1 column 2:
    3
    Enter the number for row 1 column 3:
    4
    Enter the number for row 2 column 1:
    2
    Enter the number for row 2 column 2:
    5
    Enter the number for row 2 column 3:
    8
    9 15
 */

import java.util.Scanner;

public class Sums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = input.nextInt();
        int[][] arr = new int[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                System.out.println("Enter the number for row " + (x + 1) + " column " + (y + 1) + ": ");
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
