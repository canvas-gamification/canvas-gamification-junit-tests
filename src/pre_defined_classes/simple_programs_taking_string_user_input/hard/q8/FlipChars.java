package pre_defined_classes.simple_programs_taking_string_user_input.hard.q8;

import java.util.Scanner;

public class FlipChars {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter favourite country:" );
        String word = input.nextLine();
        char first = word.charAt( 0 );
        char last = word.charAt( word.length()-1 );
        String middle = word.substring( 1, word.length()-1 );
        System.out.println( last + middle + first );
    }
}
