package arrays.multidimensional_arrays.hard.q9;

/*
Create a java program called ImAwholeDimensionAhead. This program should have a main method and method called
imAwholeDimensionAhead. This method should accept a 3D array as its parameter and print out each element to the System.
The main method should call this method with any 3D array of your choice.

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
