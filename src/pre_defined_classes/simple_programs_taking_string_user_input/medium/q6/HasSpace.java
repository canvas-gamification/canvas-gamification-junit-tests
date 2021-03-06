package pre_defined_classes.simple_programs_taking_string_user_input.medium.q6;

/*
Languages that you and I speak are written in a way that uses whitespace to separate words from one another.
Make a program that answers true or false to the question of whether the inputted sentence has at least 1 space in it.

Sample output:
    Enter any sentence:
    I think so.
    Does the sentence contain any spaces?
    true

 */

import java.util.Scanner;

public class HasSpace {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter any sentence: " );
        String response = input.nextLine();
        System.out.println( "Does the sentence contain any spaces? " );
        System.out.println( response.contains( " " ) );
    }

}
