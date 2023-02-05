package arrays.multidimensional_arrays.hard.q8;

/*
Write a program that defines a 2D array, and swaps the first row of the 2D array with the row that has the smallest sum,
and then prints the resulting array.
 */

public class LowSumSwap {
    public static void main(String[] args) {
        int[][] nums = {{41, 52, 63}, {66, 54, 21}, {90, 98, 53}, {1, 2, 3}};
        int swapi = 0;
        int lowSum = 2000000000;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums[i].length; j++) sum += nums[i][j];
            if (sum < lowSum) {
                swapi = i;
                lowSum = sum;
            }
        }
        int[] temp = nums[0];
        nums[0] = nums[swapi];
        nums[swapi] = temp;
        System.out.println("Swapped Row 1 with Row " + (swapi + 1));
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) System.out.print(nums[i][j] + " ");
            System.out.println();
        }
    }
}
