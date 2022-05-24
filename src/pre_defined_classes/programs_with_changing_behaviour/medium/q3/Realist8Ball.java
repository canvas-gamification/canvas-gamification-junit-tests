package pre_defined_classes.programs_with_changing_behaviour.medium.q3;
/*
The magic 8-ball is believed to be a reliable consultant that answers many yes/no questions. In truth, it is just a
random response generator. While the normal magic 8-ball generates responses that are quite neutral and unbiased,
sometimes people like to have some realism in the answers. Write a program that generates a random number called roll8
between 100 and 1000 (inclusive) and then divides that value by 4, and based on the remainder, prints out the value in
the following format: "You will find $25 in the next (remainder value) days."
 */

import java.util.Random;

public class Realist8Ball {
    public static void main(String[] args) {
        Random gen = new Random();
        int roll8 = gen.nextInt(901) + 100;
        int choice = roll8 % 4;
        System.out.println("You will find $25 in the next " + choice + " days.");
    }
}
