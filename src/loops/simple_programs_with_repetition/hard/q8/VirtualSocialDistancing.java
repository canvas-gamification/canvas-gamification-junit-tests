package loops.simple_programs_with_repetition.hard.q8;

/*
Write a program that will accept a string from the user that doesn't have any spaces, adds spaces between the words,
and stores it in a separate string. Assume that the first letter of every word is a capital letter.
Eg: "TodayIsANewDay" becomes "Today Is A New Day"

	Sample Output:
	Enter a sentence:
	TodayIsANewDay
	Socially Distanced String: Today Is A New Day
*/
import java.util.Scanner;
public class VirtualSocialDistancing
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a sentence: " );
        String sentence = input.next();
        String result = "" ;
        result += sentence.charAt(0);
        for(int i = 1; i < sentence.length(); i++)
        {
            if( Character.isUpperCase( sentence.charAt(i) ) )
                result += " ";
            result += sentence.charAt( i );
        }
        System.out.println( "Socially Distanced String: " + result );
    }
}

