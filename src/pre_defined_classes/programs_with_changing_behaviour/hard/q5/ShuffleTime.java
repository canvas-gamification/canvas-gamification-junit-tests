package pre_defined_classes.programs_with_changing_behaviour.hard.q5;
/*
You burn songs onto discs to sell to consumers. You're uncertain as to what song to burn onto the discs, because they
all sound great to you. Write a Java program that will randomly generate a number from 100,000 to 999,999
(inclusive of both values), and then perform two operations. First, determine the remainder of that random value after
dividing that value by 4 (mod 4), to pick what song to burn. Second, divide the random value
by 4 to determine how many discs to burn that chosen song to. Finally, print the following statement out to the console:
"You've decided to burn Song #(insert song number here), and you're making (insert number of discs here) CDs".

Distractors:
    int songChoice = gen.nextInt(4) + 1;
    int randomVal = gen.nextInt( 999000 ) + 100000;
    int randomVal = gen.nextInt( 900000 );
    int songChoice = randomVal / 4;
    int discNumber = randomVal % 4;

 */

import java.util.Random;

public class ShuffleTime {
    public static void main(String[] args) {
        Random gen = new Random();
        int randomVal = gen.nextInt(900000) + 100000;
        int songChoice = randomVal % 4;
        int discNumber = randomVal / 4;
        System.out.println("You've decided to burn Song #" + songChoice + ", and you're making " + discNumber + "CDs");
    }
}
