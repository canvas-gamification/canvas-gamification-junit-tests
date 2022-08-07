package pre_defined_classes.programs_with_changing_behaviour.hard.q8;

/*
Catan is a popular board game where players compete to gather resources and build roads and settlements. The board
consists of resource tiles which each have a number from 2 to 12 on them. On each player's turn, that player must roll
two 6 sided dice, and anyone who borders a tile with the number equal to the sum of the two dice gets to collect a
resource. Make a java program that simulates the rolling of these two dice, print each value, and print the tile number
that players can collect resources from this turn.

Sample output:
    The first die rolled is a 6.
    The second die rolled is a 4.
    Players bordering 10 may collect resources this turn.

Distractors:
    Random gen = Random();
    int firstDie = gen.nextint( 5 ) +1;
    int secondDie == gen.nextInt( 5 ) +1;
    int sumOfDice = firstDie * secondDie
    int roll = gen.nextInt( 12 ) + 1;
    System.out.println("Players bordering " + roll + " may collect resources this turn.");

 */

import java.util.Random;

public class SettlersOfCatan {
    public static void main(String[] args) {
        Random gen = new Random();
        int firstDie = gen.nextInt(6) + 1;
        System.out.println("The first die rolled is a " + firstDie + ".");
        int secondDie = gen.nextInt(6) + 1;
        System.out.println("The second die rolled is a " + secondDie + ".");
        int sumOfDice = firstDie + secondDie;
        System.out.println("Players bordering " + sumOfDice + " may collect resources this turn.");
    }
}
