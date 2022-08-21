package pre_defined_classes.programs_with_changing_behaviour.hard.q9;

/*
Make a Java program that rolls the dice for one round of Monopoly using two dice that has 6 possible values each. The
program should print out both the values of the dice, then add them to your current position on the board, which is
currently square 46, and print out your new position.

Sample output:
    The first die rolled is a 6.
    The second die rolled is a 4.
    Your new position is: 56

Distractors:
Random gen = Random();
random gen = new Random;
int firstDie = gen.nextInt( 5 ) +1;
int secondDie = gen.nextint( 6 ) +1
playerPosition = 46;
System.out.println( "Your new position is: " + firstDice + secondDice );

 */

import java.util.Random;

public class Monopoly {
    public static void main(String[] args) {
        Random gen = new Random();
        int firstDie = gen.nextInt(6) + 1;
        System.out.println("The first die rolled is a " + firstDie + ".");
        int secondDie = gen.nextInt(6) + 1;
        System.out.println("The second die rolled is a " + secondDie + ".");
        int playerPosition = 46;
        playerPosition = playerPosition + firstDie + secondDie;
        System.out.println("Your new position is: " + playerPosition);
    }
}
