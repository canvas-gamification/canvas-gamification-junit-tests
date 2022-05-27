package pre_defined_classes.simple_programs_taking_string_user_input.hard.q3;
/*
Did you know that some languages don't have any vowels or have very few vowels (e.g., 'a' and 'e')? Make a program that
takes a word from the user and changes all the vowels (a, e, i, o, u) in the word to 'e' and then displays the
resulting word. Assume the user only inputs lower case letters.

Sample Output:
	Enter a word:
	pearl
	The word is changed to: peerl

Distractors:
    Scanner input = new Scanner( System.out );
    System.out.printout( "Enter a word:" );
    String word = input.nextChar();
    String word = input.nextWord();
    word = word.replace( a, e );
    word = word.replace( e, e );
    word = word.replace( i, e );
    word = word.replace( o, e );
    word = word.replace( u, e );

 */

import java.util.Scanner;

public class removeVowel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word:");
        String word = input.nextLine();
        word = word.replace('a', 'e');
        word = word.replace('e', 'e');
        word = word.replace('i', 'e');
        word = word.replace('o', 'e');
        word = word.replace('u', 'e');
        System.out.println("The word is changed to: " + word);
        input.close();
    }
}
