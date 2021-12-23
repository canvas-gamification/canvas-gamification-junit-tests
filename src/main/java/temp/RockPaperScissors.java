package temp;

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
