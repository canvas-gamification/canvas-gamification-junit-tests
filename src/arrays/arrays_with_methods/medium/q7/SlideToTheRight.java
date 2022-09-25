package arrays.arrays_with_methods.medium.q7;

/*
Make a method that takes a character array, increment all of the values by 2, and combine all of the characters in the
array into a single String and return that string.

Distractors:
for( int i = 0; i < arr.length; i -- )
for( int i = 0; i > arr.length; i ++ )
for( int i = 0; i <= arr.length; i ++ )
arr[i] = arr[i] + 2;
s = arr[i];
s = ( char )( s + arr[i] );
return (char)s;
 */

public class SlideToTheRight {
    public static String encryptItLikeIts1950( char [] arr )
    {
        String s = "";
        for( int i = 0; i < arr.length; i ++ )
            arr[i] = (char)(arr[i] + 2);
        for( int i = 0; i < arr.length; i ++ )
            s = s + arr[i];
        return s;
    }
}
