package arrays.arrays_with_methods.hard.q1;

/*
Write a method called upByOne(int[] arr) that takes an integer array as input and increments every element of that array
by 1. The method should then return this array. For example, if the method takes in the array [1, 2, 3, 4], it should
return the array [2, 3, 4, 5].
 */
public class IncrementThis {
    public static int[] upByOne(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] + 1;
        return arr;
    }
}
