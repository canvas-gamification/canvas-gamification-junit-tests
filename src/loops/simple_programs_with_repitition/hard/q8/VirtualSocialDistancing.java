package loops.simple_programs_with_repitition.hard.q8;

/*
Write a program that will accept a string from the user that doesn't have spaces and then add spaces between the words
and store it in a separate string. Assume that the first letter of every word is a capital letter, and there are no
words that are only capital letters other than I, and A. Eg: "TodayIsANewDay" becomes "Today Is A New Day"
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
        for(int i = 0; i < sentence.length(); i++)
        {
            if( Character.isUpperCase( sentence.charAt(i) ) )
                result += " ";
            result += sentence.charAt( i );
        }
        System.out.println( "Socially Distanced String: " + result );
    }
}

