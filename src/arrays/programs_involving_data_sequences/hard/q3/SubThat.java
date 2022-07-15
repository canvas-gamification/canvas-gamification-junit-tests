package arrays.programs_involving_data_sequences.hard.q3;
/*
Write a program that calls a method called subCharacterString that takes as input a character array and two indexes to
that array. The method will then copy the characters starting from the first index all the way to the characters ending
at the second index into a String and return it as output. If the indices provided are invalid (e.g., if they exceed the
length of the character array or if the second index is smaller than the first index), then the method returns an empty
string. Print the resulting string in the main method.

 */

import java.util.Scanner;
public class SubThat
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the character array:");
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = input.next().charAt(0);
        }
        System.out.println("Enter the starting index:");
        int start = input.nextInt();
        System.out.println("Enter the ending index:");
        int end = input.nextInt();
        System.out.println("Your string is:");
        System.out.println(subCharacterString(arr, start, end));
    }
    public static String subCharacterString( char[] letters, int start, int end )
    {
        String finalWord = "";
        if( end < start )
            return finalWord;
        if( start < 0 || end > letters.length )
            return finalWord;
        for( int i = start; i < end; i++ )
            finalWord = finalWord + letters[i];
        return finalWord;
    }
}
