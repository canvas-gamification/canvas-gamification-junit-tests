package pre_defined_classes.programs_with_changing_behaviour.hard.q11;

import java.util.Random;

public class WhatAScore {
    /*
    Create a Java program to randomly generate a score and a modifier for a game. It should generate a random integer
    from 0 to 100 for the score, and a random double for the score modifier between 0 and 5. Print these values to the
    console. Then, multiply the score by the score modifier, and print this out to the console.

    Sample Output:
        Your score for this round was 45.
        The modifier for this round was 3.74.
        Your modified score is 168.3!
     */
    public static void main(String[] args) {
        Random random = new Random();
        int score = random.nextInt(100);
        double modifier = random.nextDouble() * 5.0;
        System.out.println("Your score for this round was " + score);
        System.out.println("The modifier for this round is " + modifier);
        double modifiedScore = modifier * score;
        System.out.println("Your modified score is " + modifiedScore + "!");
    }
}
