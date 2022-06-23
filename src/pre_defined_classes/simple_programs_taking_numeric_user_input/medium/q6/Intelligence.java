package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q6;
/*

A computer science teacher would like to ask the students about the intelligence of computers versus humans.
Make a program that asks the user if the user thinks that computers are smarter than humans, then generates a random
percentage and lets the user know how right s/he is.

Sample output:
Are computers smarter than humans? (0 for no, 1 for yes):
0
No? You are 44 percent correct

 */
import java.util.Scanner;
import java.util.Random;

public class Intelligence {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        Random gen = new Random();
        System.out.println( "Are computers smarter than humans? (0 for no, 1 for yes): " );
        int answer = input.nextInt();
        int pct = gen.nextInt( 100 );
        if( answer == 0 )
            System.out.print( "No? You are " + pct + " percent correct" );
        if( answer == 1 )
            System.out.print( "Yes? You are " + (100-pct) + " percent correct" );
    }

}
