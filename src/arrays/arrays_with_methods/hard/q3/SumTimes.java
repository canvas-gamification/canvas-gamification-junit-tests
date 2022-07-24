package arrays.arrays_with_methods.hard.q3;
/*
Create a method called selectiveSum(int[] arr, int var) that takes an integer array and an integer variable as input and
returns the sum of all the elements in the array that are greater than or equal to the given integer variable.
 */

public class SumTimes {
    public static int selectiveSum(int[] arr, int key) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] >= key)
                sum = sum + arr[i];
        return sum;
    }
}
