package arrays.programs_involving_multidimensional_data.hard.q6;

/*
Write a Java program that initializes a 2D array of random integers of size 5 by 5. All random values generated will be
in a range from 0 - 99 (inclusive of both ends). Print out that array in a 5x5 grid, with a space between each number
and “\n” each row. Then write a method called maxValue that takes a 2D array and return the maximum value of that array.
Then using the maxValue method print the maximum value in the generated 2D array. Your method should be general enough
to work with any size of 2D array.

Sample Output:
    Generated array:
    6 80 90 40 43
    25 77 99 18 77
    8 16 28 27 45
    90 66 4 45 79
    19 15 97 0 10
    Maximum value is: 99
 */

public class MaxVal {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        System.out.println("Generated array:");
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                arr[i][j] = (int) Math.floor(Math.random() * (100));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("Maximum value is: " + maxValue(arr));
    }

    public static int maxValue(int[][] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        }
        return max;
    }

}
