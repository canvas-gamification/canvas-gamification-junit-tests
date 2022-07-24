package pre_defined_classes.simple_programs_taking_string_user_input.medium.q8;

/*
When you create a new account on a website, you get to choose your desired username. If it is not available, some
suggestions will be made. Make a program that asks for your desired username and then suggests an alternative username
by adding three random letters from A to Z (inclusive) to the original desired username. Assume all usernames
must have at least 1 character.

Sample solution:
Please enter your username:
Jae
That name is taken. Try using this instead: JaeHVK
 */

import java.util.Random;
import java.util.Scanner;

public class UserName {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter your username:" );
        String userName = input.nextLine();
        Random gen = new Random();
        char c1 = ( char )( gen.nextInt( 26 ) + 65 );
        char c2 = ( char )(gen.nextInt( 26 ) + 65 );
        char c3 = ( char )(gen.nextInt( 26 ) + 65 );
        String otherName = userName + c1 + c2 + c3;
        System.out.println( "That name is taken. Try using this instead: " + otherName );
    }
}
