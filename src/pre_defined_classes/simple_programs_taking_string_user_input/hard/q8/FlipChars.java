package pre_defined_classes.simple_programs_taking_string_user_input.hard.q8;

/*
Create a program that takes a country name and returns it with its first and last characters swapped.
Assume all countries have at least two letters in their names.

Sample output:
Please enter a country:
Canada
aanadC

Distractors:
char first = word.charAt( 1 );
char first, last, middle;
char first, last;
char middle = word.substring( 1, word.length()-1 );
char last = word.charAt( word.length() );
char first, last;
String middle;
String middle = word.substring( 1, word.length()-2 );

 */

import java.util.Scanner;

public class FlipChars {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter a country: " );
        String word = input.nextLine();
        char first = word.charAt( 0 );
        char last = word.charAt( word.length()-1 );
        String middle = word.substring( 1, word.length()-1 );
        System.out.println( last + middle + first );
    }
}
