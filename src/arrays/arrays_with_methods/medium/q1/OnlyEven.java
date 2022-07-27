package arrays.arrays_with_methods.medium.q1;
/*
Create a method called onlyEven that takes an integer array as input and creates a new array that consists of the
elements in the even indices of the original array. This method should also return this new array. For example, if the
original array is [2, 4, 6, 9, 21, 17], the method returns [2, 6, 21] because those are the elements at indices 0, 2,
and 4. Assume that 0 is an even index.
 */

public class OnlyEven {
    public static int[] onlyEven(int[] arr) {
        int size = arr.length / 2;
        if (arr.length % 2 != 0)
            size++;
        int[] result = new int[size];
        int j = 0;
        for (int i = 0; i < arr.length; i += 2) {
            result[j] = arr[i];
            j++;
        }
        return result;
    }
}
