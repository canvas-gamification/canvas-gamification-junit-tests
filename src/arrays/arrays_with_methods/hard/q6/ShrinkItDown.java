package arrays.arrays_with_methods.hard.q6;

/*
Write a method called randomReplace that takes an integer array as input and replaces every 2nd element in it with a
random number between 0 and itself then return the array. Assume all the elements in the array are positive. For example,
if the element at arr[6] = 88, replace it with a random number between 0 and 88 ( inclusive ).
 */

public class ShrinkItDown {
    public static int[] randomReplace( int [] arr )
    {
        for( int i = 0; i < arr.length; i++ )
            if( i % 2 == 0 )
                arr[i] = (int) (Math.random() * ( arr[i] + 1 ));
        return arr;
    }
}
