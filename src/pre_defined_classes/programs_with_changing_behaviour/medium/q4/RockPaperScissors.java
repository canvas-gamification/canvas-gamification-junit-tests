package pre_defined_classes.programs_with_changing_behaviour.medium.q4;
/*
Rock-Paper-Scissors is a hand game played by many people when trying to make a decision between two friends. At the
start of each round, each player chooses one of rock, paper, or scissors. The rules of the game are that rock beats
scissors, paper beats rock, scissors beats paper. If two players display the same hand sign then it is a tie.

Intuitively, Rock-Paper Scissors is a game based on chance and can easily be programmed. Make a program that imitates
one round of Rock-Paper-Scissors between two friends. In particular, make sure that each player is able to generate 3
random numbers (1 = rock, 2 = paper, 3 = scissors). At the end of the program, display the hand signs that the two
players got so that you can see who would win.

Sample Output:
	Player One’s hand sign is: 1
	Player Two’s hand sign is: 3
 */

import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Random gen = new Random();
        int personOne = gen.nextInt(3) + 1;
        int personTwo = gen.nextInt(3) + 1;
        System.out.println("Player One's hand sign is: " + personOne);
        System.out.println("Player Two's hand sign is: " + personTwo);
    }
}
