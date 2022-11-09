package arrays.multidimensional_arrays.hard.q1;

/*
Make a program that asks the user to enter the number of rows and columns of a 2D integer array and then create that
array in the program. Also, the program should prompt the user for the values to initialize each element in that 2D array.
Finally, print the elements of this array with each row on a separate line, with spaces between each number. Assume that
the user will enter positive integers for the row and column numbers.

Sample output:
    Enter the number of rows:
    2
    Enter the number of columns:
    3
    Enter the number to store at row 1, column 1:
    8
    Enter the number to store at row 1, column 2:
    7
    Enter the number to store at row 1, column 3:
    6
    Enter the number to store at row 2, column 1:
    5
    Enter the number to store at row 2, column 2:
    4
    Enter the number to store at row 2, column 3:
    3
    8 7 6
    5 4 3
 */

import java.util.Scanner;

public class AscendDimensions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int row = input.nextInt();
        System.out.println("Enter the number of columns: ");
        int col = input.nextInt();
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the number to store at row " + (i + 1) + ", column " + (j + 1) + ": ");
                nums[i][j] = input.nextInt();
            }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
