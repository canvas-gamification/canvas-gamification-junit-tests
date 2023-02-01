package arrays.programs_involving_multidimensional_data.hard.q6;

/*
Write a Java program that initializes a 2D array of random integers of size 5 by 5. All random values generated will be
in a range from 0 - 99 (inclusive of both ends). Print out that array in a 5x5 grid, with a space between each number
and “\n” each row.  The program then determines the highest value in the entire array and returns that value
 */

public class MaxVal {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                arr[i][j] = (int) Math.floor(Math.random() * (100));
        int highestVal = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > highestVal)
                    highestVal = arr[i][j];
            }
            System.out.println();
        }
        System.out.println(highestVal);
    }

}
