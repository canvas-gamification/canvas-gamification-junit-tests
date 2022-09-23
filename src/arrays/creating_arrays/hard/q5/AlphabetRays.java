package arrays.creating_arrays.hard.q5;

/*
Write a Java program called AlphabetRays to initialize an integer array with all of the lowercase letters of the English
alphabet and print each character on a separate line. Recall that the character a has the integer equivalent value of 97.
Sample output:
a
b
…
y
z
 */

public class AlphabetRays
{
    public static void main( String [] args )
    {
        char[] arr = new char[26];
        for( int i = 0; i < arr.length; i++ )
            arr[i] = (char) ( 97 + i );
        for( int i = 0; i < arr.length; i++ )
            System.out.println(arr[i]);
    }
}
