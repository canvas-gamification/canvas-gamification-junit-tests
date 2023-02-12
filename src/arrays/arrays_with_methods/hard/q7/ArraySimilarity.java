package arrays.arrays_with_methods.hard.q7;

/*
Write a method called isEqual that takes two integer arrays of any length as input and checks each of their elements one
at a time to see whether all of their elements are the same or not. The method returns true if all the elements of the
two arrays are the same, and false otherwise.
 */

public class ArraySimilarity {
    public static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }
}
