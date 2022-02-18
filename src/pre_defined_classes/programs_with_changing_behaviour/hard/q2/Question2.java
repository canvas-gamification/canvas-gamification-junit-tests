package pre_defined_classes.programs_with_changing_behaviour.hard.q2;
import java.util.Random;

/*
Make a program that will generate a random <strong>8 digit</strong> number and encrypt it by dividing it by a second
random <strong>1-digit</strong> number. At the end of the program, print out these numbers.
Sample Output: 68056441 has been encrypted using 5 into 13611288
 */

public class Question2 {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int crypt = gen.nextInt( 90000000 ) + 10000000;
        int key = 1 + gen.nextInt( 9 );
        int encrypt = crypt / key ;
        System.out.println( crypt + " has been decrypted using " + key + " into " + encrypt);
    }
}
