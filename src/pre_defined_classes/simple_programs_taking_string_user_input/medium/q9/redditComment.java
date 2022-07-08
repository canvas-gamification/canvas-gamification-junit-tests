package pre_defined_classes.simple_programs_taking_string_user_input.medium.q9;

/*
People use reddit to share interesting pictures and information. Most reddit users think that using capitalized letters
makes their comment bigger, bolder, and better. However, reddit moderators do not allow capitalized comments on the
website. Make a program that reads in a user's comment and convert it to lowercase.

Sample output:
Enter your comment:
BBC news is reporting abc
Your lowercase comment is: bbc news is reporting abc

 */

import java.util.Scanner;

public class redditComment {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter your comment:" );
        String comment = input.nextLine();
        System.out.println( "Your lowercase comment is: " + comment.toLowerCase() );
    }

}
