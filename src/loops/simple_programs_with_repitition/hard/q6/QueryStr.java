package loops.simple_programs_with_repitition.hard.q6;

/*
Search Engines usually make formatted "Query Strings" by replacing the spaces in a search term with a special character.
Write a program that will accept a search term from the user and replace all the spaces with "%20%" and store the result
in a separate string variable. Eg: " Hello There " becomes "%20%Hello%20%There%20%."
Use a single-layered loop to write this program.

	Sample Output:
	Enter a sentence:
	 Hello There
	The new query string is: %20%Hello%20%There%20%
 */

import java.util.Scanner;
public class QueryStr
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a sentence: " );
        String sentence = input.nextLine();
        String result = "" ;
        for(int i = 0; i < sentence.length(); i++)
        {
            if(sentence.charAt(i) == ' ')
                result += "%20%";
            else
                result += sentence.charAt( i );
        }
        System.out.println( "The new query string is: " +  result);
    }
}
