package pre_defined_classes.programs_with_changing_behaviour.hard.q8;

/*
Snakes and Ladders is a board game where players have to reach the final position on the board (assume that players have
to reach the Spot #100). Unfortunately, if the player hits certain spots that have a snake on them, they move further
down the board. (For this game, positions 23, 54, 34, 78, 86, 96 are positions with snakes on them). If a person lands
on a snake, their position goes back 19 spots. Make a Java program that randomly rolls a pair of dice, and then
increments a player's position on a board of Snakes and Ladders. Can you tell if the position has a snake on it?

Sample output:
Your new position is: 58

Distractors:
Random gen = Random();
 int firstDice = gen.nextint( 5 ) +1;
 int secondDice == gen.nextInt( 5 ) +1;
 playerPosition = playerPosition - ( firstDice + secondDice );
 int secondDice = gen.nextInt( 10 ) +1;
 System.out.println( "Your new position is: " + firstDice + secondDice );

 */

import java.util.Random;

public class SnakesAndLadders {
    public static void main( String[] args ) {
        Random gen = new Random();
        int firstDice = gen.nextInt(6) + 1;
        int secondDice = gen.nextInt(6) + 1;
        int playerPosition = 46;
        playerPosition = playerPosition + firstDice + secondDice;
        System.out.println("Your new position is: " + playerPosition);
    }
}
