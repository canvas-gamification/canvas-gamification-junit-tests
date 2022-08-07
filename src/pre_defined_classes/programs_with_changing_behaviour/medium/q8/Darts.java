package pre_defined_classes.programs_with_changing_behaviour.medium.q8;

/*
Make a Java program that plays a round of darts for a player. Darts is a target throwing game where players throw darts
onto a circular board. The closer the dart is to the center, the more points a player scores. Players can score up to
20 points if they land on the bullseye. Players throw three darts before their round is over, and their best score is
the one that they get to keep. Generate and print three random numbers from 0 to 20 (inclusive) to serve as the player's throws,
then take the maximum of them, and print that as the score for the round.

Sample output:
    Nice! You scored 19 points this round!

 */

import java.util.Random;

public class Darts {
    public static void main(String[] args) {
        Random gen = new Random();
        int firstThrow = gen.nextInt(21);
        System.out.println("Your first throw scored " + firstThrow + " points.");
        int secondThrow = gen.nextInt(21);
        System.out.println("Your second throw scored " + secondThrow + " points.");
        int thirdThrow = gen.nextInt(21);
        System.out.println("Your third throw scored " + thirdThrow + " points.");
        int playerScore = Math.max(firstThrow, secondThrow);
        int maxValue = Math.max(playerScore, thirdThrow);
        System.out.println("Nice! You scored " + maxValue + " points this round!");
    }
}
