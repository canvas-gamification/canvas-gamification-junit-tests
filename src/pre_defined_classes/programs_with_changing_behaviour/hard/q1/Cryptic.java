package pre_defined_classes.programs_with_changing_behaviour.hard.q1;

/*
Make a program that will generate a random 8-digit number and encrypt it by multiplying it by a second random 1-digit
number. At the end of the program, print out these numbers.

Sample Output:
    66745532 has been encrypted using 6 into 333727660

Distractors:
    double crypt = gen.nextDouble( 100000000 );
    int crypt = gen.next( 90000000 ) + 10000000;
    int crypt = gen.nextInt( 10000000 );
    int key = gen.nextInt( 9 );
    int encrypt = 1 + gen.nextInt( 10 );
    double encrypt *= crypt;
    int encrypt = gen.nextInt( 10 ) * crypt;
    import java.util.Scanner;
 */

import java.util.Random;

public class Cryptic {
    public static void main(String[] args) {
        Random gen = new Random();
        int crypt = gen.nextInt(90000000) + 10000000;
        int key = gen.nextInt(9) + 1;
        int encrypt = crypt * key;
        System.out.println(crypt + " has been encrypted using " + key + " into " + encrypt);
    }
}
