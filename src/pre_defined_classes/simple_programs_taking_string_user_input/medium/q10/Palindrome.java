package pre_defined_classes.simple_programs_taking_string_user_input.medium.q10;

/*
A palindrome is a word that is the same when read either forwards or backwards, such as “eye”, “mom”, and “noon”.
Make a program that takes a 3-letter word from the user and answers true or false to the question of whether the word
is a palindrome or not. Assume all inputs are exactly 3 letters and all are in lower case.

Sample output:
Enter your word:
jam
Is the given word a palindrome? false

Enter your word:
lol
Is the given word a palindrome? true

 */

import java.util.Scanner;

public class Palindrome {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter your word:" );
        String word = input.nextLine();
        boolean hasThreeLetters = word.length() == 3;
        boolean hasSameFirstAndLastLetters = word.charAt(0) == word.charAt(2);
        boolean check = hasThreeLetters && hasSameFirstAndLastLetters;
        System.out.println( "Is the given word a palindrome? " + check );
    }
}
