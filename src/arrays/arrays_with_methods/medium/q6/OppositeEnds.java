package arrays.arrays_with_methods.medium.q6;

/*
Make a method that takes an integer array as input and returns a new array that consists of the largest and smallest
value in the original array. Assume that the numbers in the array are between 0 and 100.

Distractors:
for( int i = 0; i < arr.length; i -- )
for( int i = 0; i > arr.length; i ++ )
for( int i = 0; i <= arr.length; i ++ )
if( arr[i] < large )
if( arr > large )
arr[i] = small;
large = arr;
small = arr;
if( arr[i] > small )
if( arr < small )
 */

public class OppositeEnds {
    public static int[] smallAndLarge(int[] arr) {
        int large = -9999999;
        int small = 9999999;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large)
                large = arr[i];
            if (arr[i] < small)
                small = arr[i];
        }
        return new int[]{large, small};
    }
}
