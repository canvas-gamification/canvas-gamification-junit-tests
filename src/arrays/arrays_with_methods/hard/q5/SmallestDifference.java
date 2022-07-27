package arrays.arrays_with_methods.hard.q5;

/*
Write a method called smallestDiff that takes an integer array as input and returns the smallest difference between two
adjacent elements in the array as an integer. For example, given [ 1, 3, 5, 4, 12 ] as the input array, the method
returns 1 because the smallest difference is found between 5 and 4. Note that the difference should only be positive,
so the difference between 4 and 5 is the same as 5 and 4. If the array is empty or contains one value, the method should
return zero.
 */

public class SmallestDifference {
    public static int smallestDiff(int[] arr) {
        if(arr.length == 0 || arr.length == 1)
            return 0;
        int smallDiff = Math.abs(arr[1] - arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if (diff < smallDiff)
                smallDiff = diff;
        }
        return smallDiff;
    }
}
