package arrays.multidimensional_arrays.hard.q5;

/*
Create a program that initializes a multidimensional array of integers, calculates the sum and the average of the
elements in the array, and then prints out those values.
 */

public class SumAverageProgram {

    public static void main(String[] args) {
        int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583, 1738}};

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];

            }

        double count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++) {
                count++;
            }
        double avg = sum / count;

        System.out.println("The 2D array has the sum of " + sum + " and the average of " + avg + ".");
    }
}
