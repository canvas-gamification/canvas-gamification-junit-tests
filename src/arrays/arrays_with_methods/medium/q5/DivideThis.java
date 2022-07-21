package arrays.arrays_with_methods.medium.q5;
/*
Create a method called isItDivisible that takes an integer array as input and returns true if every element of the array
is divisible by 4.

Distractors:
    public static boolean isItDivisible( int  arr )
    boolean b;
    b = False;
    for( int i = 0; i < arr.length(); i++ )
    for( int i = 0; i <= arr.length; i++ )
    for( int i = 0; i < arr.length; i-- )
    for( int i = 0; i > arr.length; i++ )
    if( arr[i] % 40 == 0 )
    if( arr[i] / 4 == 0 )
    if( arr[i] % 4 )
 */

public class DivideThis {
    public static boolean isItDivisible(int[] arr) {
        boolean b = true;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 4 == 0)
                b = true;
            else {
                b = false;
                break;
            }
        return b;
    }
}
