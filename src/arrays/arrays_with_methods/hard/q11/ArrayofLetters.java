package arrays.arrays_with_methods.hard.q11;

/*
Write a Java program that asks the user to enter a sentence into the console. Then, using a method called charFinder,
create a character array that stores the first letter of each word into that array, and returns that array. Lastly, in
the main method, print out the character array.
Recall that Java has a handy string method called split() that takes a string and returns an array of substrings
separated by a character. You may choose to use this method or write your own loop to create the array required in the
question.

Sample output:
Enter a sentence:
Mister blue sky, please tell us why
M
b
s
p
t
u
w
 */

import java.util.Scanner;
public class ArrayofLetters
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter a sentence: ");
        String[] userSentence = input.nextLine().split(" ");
        char[] sent = charFinder(userSentence);
        for( int i = 0; i < sent.length; i++ )
            System.out.println(sent[i]);
    }
    public static char[] charFinder(String[] input)
    {
        char[] arr = new char[input.length];
        for( int i = 0; i < arr.length; i++ )
            arr[i] = input[i].charAt(0);
        return arr;
    }
}
