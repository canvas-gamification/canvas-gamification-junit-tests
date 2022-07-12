package pre_defined_classes.programs_with_changing_behaviour.hard.q10;

/*
Many people claim that Bob's predictions are accurate. You want to test if Bob is actually good or is lying.
You have a bowl of papers with numbers from 0-20 on them. You pick three pieces of paper with numbers on them and want
to see if Bob can guess them correctly. Make a Java program that generates three numbers for Bob.

Sample output:

Distractors:
int bobsNumber = 5:
 Random gen == new Random();
 Double firstPaper = gen.nextInt(20);
 String secondPaper  = gen.nextInt(20);
 int thirdPaper = gen.nextInt(19);

 */

import java.util.Random;

public class ProphetBot {
    public static void main( String[] args )
    {
        int bobsNumber = 5;
        Random gen = new Random();
        int firstPaper = gen.nextInt(20);
        int secondPaper  = gen.nextInt(20);
        int thirdPaper = gen.nextInt(20);
        System.out.println("The first paper is: " + firstPaper);
        System.out.println("The second paper is: " + secondPaper);
        System.out.println("The third paper is: " + thirdPaper);
    }
}
