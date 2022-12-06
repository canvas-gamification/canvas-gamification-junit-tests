package arrays.multidimensional_arrays.hard.q5;

/*
Create a program that initializes a multidimensional array of integers, and then uses methods to calculate the sum and
the average of the elements in the array. The main method should then print out those values. The first method, SumArray,
should accept a multidimensional array of integers and returns the sum of all values in that array. The second method,
AvgArray, should take a multidimensional array of integers and return the average value of the array as a double. Both
methods should work with an array of any length.
 */

public class SumAverageProgram {

    public static void main(String[] args) {
        int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583, 1738}};
        int x = SumArray(nums);
        double y = AvgArray(nums);
        System.out.println("The 2D array has the sum of " + x + " and the average of " + y + ".");
    }


    public static int SumArray(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];

            }

        return sum;
    }

    public static double AvgArray(int[][] nums) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++) {
                sum += nums[i][j];
                count++;
            }
        double avg = sum / count;
        return avg;
    }
}
