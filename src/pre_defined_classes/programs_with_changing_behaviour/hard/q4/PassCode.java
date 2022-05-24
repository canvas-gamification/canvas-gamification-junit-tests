package pre_defined_classes.programs_with_changing_behaviour.hard.q4;

/*
Write a Java program that will generate a random and print a 6-digit phone password to suggest to the user. The range of
possible values being: 000000 - 999999 ( inclusive of 000000 and 999999 ).

Sample Output:
	Random Passcode: 1 2 3 4 5 6

Distractors:
    int n1, n2, n3, n4, n5, n6;
    n1 = n2 = n3 = n4 = n5 = n6 = gen.nextInt( 9 );
    n1 = n2 = n3 = n4 = n5 = n6 = gen.nextInt( 10 );
    int n1 = gen.nextInt( 9 );
    int n2 = gen.nextInt( 9 );
    int n3 = gen.nextInt( 9 );
    int n4 = gen.nextInt( 9 );
    int n5 = gen.nextInt( 9 );
    int n6 = gen.nextInt( 9 );
    System.out.println(“Random Passcode: “ + n1 + n2 + n3 + n4 + n5 + n6 );

 */

import java.util.Random;

public class PassCode {
    public static void main(String[] args) {
        Random gen = new Random();
        int n1 = gen.nextInt(10);
        int n2 = gen.nextInt(10);
        int n3 = gen.nextInt(10);
        int n4 = gen.nextInt(10);
        int n5 = gen.nextInt(10);
        int n6 = gen.nextInt(10);
        System.out.println("Random Passcode: " + n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5 + " " + n6);
    }
}
