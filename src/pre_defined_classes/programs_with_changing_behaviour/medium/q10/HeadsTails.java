package pre_defined_classes.programs_with_changing_behaviour.medium.q10;

/*
Make a Java program that plays three rounds of heads or tails. Heads or tails is a coin toss game where two players
pick either heads or tails, and whichever side comes up when tossing the coin wins that round. For this program, if the
program obtains a 1, then it's heads, and if it is 0, it's tails. Player 1 picked heads for all the rounds, and Player
2 picked tails for all the rounds. Display the result of each turn and how many times Player 1 won.

Sample output:
Turn 1: 1
Turn 2: 0
Turn 3: 1
Player 1 won 2 out of the 3 rounds

 */

import java.util.Random;

public class HeadsTails {
    public static void main(String[] args) {
        Random gen = new Random();
        int firstToss = gen.nextInt(2);
        System.out.println("Turn 1: " + firstToss);
        int secondToss = gen.nextInt(2);
        System.out.println("Turn 2: " + secondToss);
        int thirdToss = gen.nextInt(2);
        System.out.println("Turn 3: " + thirdToss);
        int wins = firstToss + secondToss + thirdToss;
        System.out.println("Player 1 won " + wins + " out of the 3 rounds");
    }
}
