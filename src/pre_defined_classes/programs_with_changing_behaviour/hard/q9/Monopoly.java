package pre_defined_classes.programs_with_changing_behaviour.hard.q9;

/*
Make a Java program that rolls the dice for one round of Monopoly using two dice that has 6 possible values each.

Sample output:
Your new position is: 49

Distractors:
Random gen = Random();
random gen = new Random;
int firstDice = gen.nextInt( 5 ) +1;
int secondDice = gen.nextint( 6 ) +1
playerPosition = 46;
System.out.println( "Your new position is: " + firstDice + secondDice );

 */

import java.util.Random;

public class Monopoly {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int firstDice = gen.nextInt( 6 ) +1;
        int secondDice = gen.nextInt( 6 ) +1;
        int playerPosition = 46;
        playerPosition = playerPosition + firstDice + secondDice;
        System.out.println( "Your new position is: " + playerPosition );
    }
}
