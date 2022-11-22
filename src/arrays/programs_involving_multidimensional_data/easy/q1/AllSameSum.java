package arrays.programs_involving_multidimensional_data.easy.q1;

/*
Write a Java program that initialises a 4 by 4 multidimensional array of integers with values given by the user, and
prints true if all the rows have the same sum and false otherwise.
 */

import java.util.Scanner;

public class AllSameSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr = new int[4][4];

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                System.out.println("Enter the value for row " + x + " column " + y + ": ");
                arr[x][y] = input.nextInt();
            }
        }

        boolean sumEqual = true;
        int[] sumArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                sumArray[i] += arr[i][j];
        for (int i = 0; i < sumArray.length - 1; i++)
            if (sumArray[i] != sumArray[i + 1]) sumEqual = false;
        System.out.println(sumEqual);
    }
}
