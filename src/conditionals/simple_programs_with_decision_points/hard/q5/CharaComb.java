package conditionals.simple_programs_with_decision_points.hard.q5;

import java.util.Scanner;

/*
Write a program that will take a single letter as an input and display a message saying "Vowel", when the character is a vowel,
and "Not a vowel" when it is not a vowel. Assume the user will only enter a lowercase letter.

Distractors:
if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' );
if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
if( c == 'a' || 'e' || 'i' || 'o' || 'u' )
if( c == 'a' || 'e' || 'i' || 'o' || 'u' );
if c == 'a' || 'e' || 'i' || 'o' || 'u'
if( c == 'a' && c == 'e' && c == 'i' && c == 'o' && c == 'u' )
if( c == 'a' && c == 'e' && c == 'i' && c == 'o' && c == 'u' );
 */
public class CharaComb {
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter a character: ");
        char c = input.next().charAt(0); //Extracts the first character entered by the user
        if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
            System.out.println("Vowel");
        else
            System.out.println("Not a vowel");
    }

}
