package arrays.multidimensional_arrays.hard.q9;

/*
Make a Java program that initializes a 3 * 3 * 3 3D array with integer input from the user, then ask the user which
2-d arrays to swap and then swap them (the indexes given will refer to the first index slot). Finally, print the array
using the Arrays.deepToString() method from the java.util.Arrays import.

Sample output:
    Enter the array values:
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27
    Enter the array indexes to swap:
    2 0
    [[[19, 20, 21], [22, 23, 24], [25, 26, 27]], [[10, 11, 12], [13, 14, 15], [16, 17, 18]], [[1, 2, 3], [4, 5, 6], [7, 8, 9]]]
 */

import java.util.Arrays;
import java.util.Scanner;

public class ImAWholeDimensionAhead {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][][] nums = new int[3][3][3];

        System.out.println("Enter the array values:");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++)
                    nums[i][j][k] = in.nextInt();
            }
        }
        System.out.println("Enter the array indexes to swap:");
        int i1 = in.nextInt();
        int i2 = in.nextInt();

        int[][] hold = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = hold;

        System.out.println(Arrays.deepToString(nums));
    }
}
