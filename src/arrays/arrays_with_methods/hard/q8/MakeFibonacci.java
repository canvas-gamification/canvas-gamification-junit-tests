package arrays.arrays_with_methods.hard.q8;

/*
Write a Java method called fibbingArray that takes an integer size variable as input and returns an integer array of length 
size populated with the terms of the Fibonacci sequence. Recall that the Fibonacci sequence starts with F0 = 0, F1 = 1, and 
then all future values are defined by the previous values using the formula: Fn= Fn-1+Fn-2. For example, if the integer 
passed to your method was five, you would return the array {0, 1, 1, 2, 3}. You can assume that the method's input variable 
will always be an integer greater than 1.
 */

public class MakeFibonacci {
    public static int[] fibbingArray( int size )
    {
        int [] result = new int[size];
        result[0] = 0;
        result[1] = 1;
        for( int i = 2; i < result.length; i++ )
            result[i] = result[ i - 1 ] + result[ i - 2 ];
        return result;
    }

}
