package pre_defined_classes.programs_with_changing_behaviour.medium.q7;

/*
You are taking a multiple choice exam and are stuck on a question. The question has 5 possible responses to choose from,
but you don't know which one you should pick. Make a Java program that creates a random number from 1 to 50000
(inclusive of both values), then takes the remainder of the random value divided by the number of possible responses
and display that output.

Sample output:
The response you should pick is #1

 */

import java.util.Random;

public class ShuffleChoices {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int randomVal = gen.nextInt( 50000 ) + 1;
        int answerChoice = randomVal % 5;
        System.out.println( "The response you should pick is #" + answerChoice );
    }
}
