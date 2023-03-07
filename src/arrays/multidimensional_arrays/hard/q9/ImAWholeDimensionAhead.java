package arrays.multidimensional_arrays.hard.q9;

/*
Make a Java program that randomly initialize a 3 * 3 * 3 3D array with integers ranging from 1 to 100
(Inclusive of both ends), and then print it, in one line. For that you need to make a method that takes a 3D integer
array and the print it in one line. For example if the 3D array is {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}} you should print
1 2 3 4 5 6 7 8. Note that your method should be general enough to work with any size of array.

Sample output;
    12 84 9 8 6 28 46 35 77 91 22 21 24 38 35 40 74 90 43 11 68 58 24 41 46 17 25

 */

public class ImAWholeDimensionAhead {
    public static void main(String[] args) {
        int[][][] nums = new int[3][3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++)
                    nums[i][j][k] = (int) (Math.random() * 100);
            }
        }
        imAWholeDimensionAhead(nums);
    }

    public static void imAWholeDimensionAhead(int[][][] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++)
                    System.out.print(nums[i][j][k] + " ");
            }
        }
    }
}
