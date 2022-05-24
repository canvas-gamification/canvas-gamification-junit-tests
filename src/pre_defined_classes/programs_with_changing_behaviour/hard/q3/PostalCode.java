package pre_defined_classes.programs_with_changing_behaviour.hard.q3;
/*
Make a program that randomly generates a Canadian postal code in a zone that alternates between an uppercase letter
which must be from A to F (inclusive) and a numeric digit (e.g., a valid postal code is C5F8A1). Recall that capital
letters correspond to numbers in the range of 65-90 and that there are 6 possible capital letters for this zone.

Sample Output:
	Random Postal Code: A1B2C3

Distractors:
    char c1 = ( char )(gen.nextInt( 5 ) + 65 );
    char c3 = ( char )(gen.nextInt( 5 ) + 65 );
    char c2 = ( char )(gen.nextInt( 5 ) + 65 );
    char c1, c2, c3;
    int n1, n2, n3;
    int n2 = gen.nextInt( 9 );
    int n1 = gen.nextInt( 9 );
    int n3  = gen.nextInt( 9 );
    char c1 = ( char )(gen.nextInt( 26 ) + 65 );
    char c3 = ( char )(gen.nextInt( 26 ) + 65 );
    char c2 = ( char )(gen.nextInt( 26 ) + 65 );

 */

import java.util.Random;

public class PostalCode {
    public static void main(String[] args) {
        Random gen = new Random();
        char c1 = (char) (gen.nextInt(6) + 65);
        int n1 = gen.nextInt(10);
        char c2 = (char) (gen.nextInt(6) + 65);
        int n2 = gen.nextInt(10);
        char c3 = (char) (gen.nextInt(6) + 65);
        int n3 = gen.nextInt(10);
        System.out.println("Random Postal Code: " + c1 + n1 + c2 + n2 + c3 + n3);
    }
}
