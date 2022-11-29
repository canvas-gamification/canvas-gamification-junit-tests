package arrays.multidimensional_arrays.hard.q3;

/*
Make a Java program that initializes a multidimensional array in the main method and calls the countsOdd method. The
countsOdd method should accept a multidimensional array of integers, count the number of odd integers in the array, and
print the count.

Sample output:
    count of odd numbers in array = 2
 */

public class CountsOdd {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        countsOdd(arr);
    }

    public static void countsOdd(int[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                if (nums[i][j] % 2 != 0)
                    count++;
        System.out.println("count of odd numbers in array = " + count);
    }
}
