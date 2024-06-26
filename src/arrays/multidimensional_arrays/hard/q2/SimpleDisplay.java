package arrays.multidimensional_arrays.hard.q2;

/*
Write a Java program called SimpleDisplay. It should have a main method asking the user for the number of rows and
columns in an array and initialize an array of that size. Then, it should prompt the user to enter the values for this
array. It should then count the number of elements in it that are even, printing the indices these values are located at,
and then print out the total count. Assume the user will provide integers greater than or equal to zero for the array row
and column lengths.

Sample output:
    Enter the number of rows:
    3
    Enter the number of columns:
    2
    Enter the values for the array:
    1 2 3 4 5 6
    Even integers located at: 01 10 12
    The number of even integers in array is: 3
 */

import java.util.Scanner;

public class SimpleDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = input.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter the values for the array: ");
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                arr[x][y] = input.nextInt();
            }
        }

        System.out.print("Even integers located at: ");
// maybe make it print processing, and then print out the indices of the even variables it comes across
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] % 2 == 0) {
                    System.out.print(i + "" + j + " ");
                    count++;
                }
        System.out.println();
        System.out.println("The number of even integers in array is: " + count);
    }
}

