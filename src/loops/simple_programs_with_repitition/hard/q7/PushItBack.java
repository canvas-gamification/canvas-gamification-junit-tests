package loops.simple_programs_with_repitition.hard.q7;

/*
Write a java program called PushItBack that takes a string from the user and moves all of the numbers to the end of the string.
Eg: "12Hello90Bye5" becomes "HelloBye12905".
( Hint: Use two strings and join them together after splitting the string )

Sample Output:
	Enter a sentence:
	12Hello90Bye5
	Result String: HelloBye12905
 */

import java.util.Scanner;
public class PushItBack
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a sentence: " );
        String sentence = input.nextLine();
        String numbers = "" ;
        String notNumbers = "" ;
        for(int i = 0; i < sentence.length(); i++)
        {
            if( Character.isDigit( sentence.charAt(i) ) )
                numbers += sentence.charAt( i );
            else
                notNumbers += sentence.charAt( i );
        }
        System.out.println( "Result String: " + notNumbers + numbers);
    }
}
