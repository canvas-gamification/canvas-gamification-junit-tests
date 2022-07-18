package pre_defined_classes.simple_programs_taking_string_user_input.hard.q10;

/*
Passwords are one of the most important things that everyone in the digital world has to take care of. Some of the most
popular passwords that are easily guessed by hackers contain the word "password" or the numbers "1234". Make a program
that asks the user to enter a password, then checks if the password is strong or not. For this question, a password is
weak if it can be easily guessed based on the criteria above (this means it contains the two parameters above).
The program will print true or false depending on whether the inputted password is weak. Assume users always enter a
password with at least 4 characters.


Sample output:
Please enter a password
1234abc
Is the password too weak? true

Distractors:
pass = input.nextChar();
pass = input.next();
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
        String pass = input.nextLine();
        pass = pass.toLowerCase();
        boolean hasWord = pass.contains( "password" );
        boolean hasNums = pass.contains( "1234" );
        System.out.println( "Is the password too weak? " + (hasWord || hasNums) );
    }

}
