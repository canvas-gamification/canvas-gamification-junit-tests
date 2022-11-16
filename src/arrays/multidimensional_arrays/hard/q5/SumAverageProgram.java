package arrays.multidimensional_arrays.hard.q5;

/*
Make two methods named SumArray and AvgArray. Sum Array should accept a multidimensional array of integers
( int [][]nums ) and return the sum of all values of that array, it should return an integer. AvgArray should accept a
multidimensional array of integers ( int [][]nums ) and return the average of values of that array, it should return a
double. Both Methods should be able to handle arrays of any size
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
