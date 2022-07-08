package pre_defined_classes.simple_programs_taking_string_user_input.hard.q7;

/*
Syllables in Japanese follow a "CV structure", which means that every syllable is made up of a consonant followed by a
vowel. Make a program that asks a user to enter a syllable that has two letters and print true or false depending on
whether it has the CV structure. For simplicity, we consider a vowel to be one of a, e, i, o, u only. Assume all users
always enter 2 characters as an input.

Sample output:
Enter a syllable:
ka
Does the input syllable have CV structure? true

Enter a syllable:
bb
Does the input syllable have CV structure? false

Distractors:
System.out.println( "Your syllable has a CV structure" );
char one = syllable.charAt( 1 );
char two = syllable.charAt( 2 );
boolean isConsonant, isVowel, isCV;
String one = syllable.charAt( 0 );
String two = syllable.charAt( 1 );
boolean isConsonant = (one != 'a' || one != 'e' || one != 'i' || one != 'o' || one != 'u');
boolean isCV = isConsonant || isVowel;
boolean isVowel = (two == 'a' && two== 'e' && two == 'i' && two == 'o' && two == 'u');

 */

import java.util.Scanner;

public class Syllable {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a syllable: " );
        String syllable = input.nextLine();
        char one = syllable.charAt( 0 );
        char two = syllable.charAt( 1 );
        boolean isConsonant = (one != 'a' && one != 'e' && one != 'i' && one != 'o' && one != 'u');
        boolean isVowel = (two == 'a' || two== 'e' || two == 'i' || two == 'o' || two == 'u');
        boolean isCV = isConsonant && isVowel;
        System.out.println( "Does the input syllable have CV structure? " + isCV );
    }

}
