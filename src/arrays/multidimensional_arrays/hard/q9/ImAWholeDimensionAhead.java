package arrays.multidimensional_arrays.hard.q9;

/*
Make a java program that defines a 3D array in the main method and then passes it to a method called
imAWholeDimensionAhead. This method should accept a 3D array and print out each element on the same line.
 */

public class ImAWholeDimensionAhead {
    public static void main(String[] args) {
        int[][][] nums =
                {{{1, 2}, {3, 4}, {5, 6}},
                {{2, 1}, {4, 4}, {11, 0}},
                {{12, 24}, {31, 44}, {51, 60}}};
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
