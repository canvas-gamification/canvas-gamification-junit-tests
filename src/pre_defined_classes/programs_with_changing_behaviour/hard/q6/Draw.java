package pre_defined_classes.programs_with_changing_behaviour.hard.q6;

/*
Make a program that randomly selects a student from a new cohort to win a prize by drawing a random student ID between
10000000 and 99999999 (includes 10000000, excludes 99999999).

Sample output:
Congratulations Student Number : 37280153! You win!

Distractors:
int sno = gen.nextInt( 99999999 );
int sno = 10000000 + gen.nextInt( 99999999 );
int sno = 89999999 + gen.nextInt( 10000000 );
int sno = gen.nextint( 99999999 );
int sno = 10000000 + gen.nextint( 89999999 );

 */

import java.util.Random;

public class Draw {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int sno = 10000000 + gen.nextInt( 89999999 );
        System.out.println("Congratulations Student Number : " + sno + "! You win!");
    }
}
