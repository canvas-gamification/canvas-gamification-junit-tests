package arrays.arrays_with_methods.hard.q4;
/*
Write a method called isAscending that takes an array of type double and returns true if the elements of the array are
in ascending order (smallest to largest) and false otherwise. Assume that if two elements are adjacent and equal they
are in the correct order.
 */
public class NumbersAscend {
    public static boolean isAscending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;
        return true;
    }

}
