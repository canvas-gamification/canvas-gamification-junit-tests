package pre_defined_classes.simple_programs_taking_string_user_input.hard.q10;

/*
Password security is one of the most important things in the digital world we live in.
Make a program that asks the user to enter a password to determine the strength of it (either strong or weak).
The program will print true if the inputted password is weak. Visa versa.
A password is weak if it can be easily guessed because it contains commonly used character combinations.
For this question, a password is weak if it contains either the word "password" or the numbers "1234".
Assume inputted passwords do not contain whitespaces.


Sample output:
Please enter a password
1234abc
Is the password too weak? true

Distractors:
pass = input.nextChar();
pass = input.nextLine();
String hasWord, hasNums, isWeak;
System.out.print( "Please enter a password" );
System.out.println( "Is the password too weak? " + isWeak );
String pass;
boolean hasWord, hasNums, isWeak;
isWeak = hasWord || hasNums;
System.out.println( "Is the password too weak? " );

 */

import java.util.Locale;
import java.util.Scanner;

public class PasswordWeakness {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter a password: " );
        String pass = input.next();
        pass = pass.toLowerCase();
        boolean hasWord = pass.contains( "password" );
        boolean hasNums = pass.contains( "1234" );
        System.out.println( "Is the password too weak? " + (hasWord || hasNums) );
    }

}
