package arrays.multidimensional_arrays.hard.q2;

/*
Write a Java program called SimpleDisplay. It should have a main method which asks the user for the number of rows,
columns, and array values, and passes that array to a method called simpleDisplay. The method simpleDisplay should
accept a multidimensional 2D array (int [][] nums), and count the number of elements in it that are even. The count is
printed out in the method. This should work for any size 2D array.

Sample output:
    Enter the number of rows:
    3
    Enter the number of columns:
    2
    Enter the values for the array:
    1 2 3 4 5 6
    count of even numbers in array = 3
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

        simpleDisplay(arr);
    }

    public static void simpleDisplay(int[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                if (nums[i][j] % 2 == 0)
                    count++;
        System.out.println("count of even numbers in array = " + count);
    }
}

