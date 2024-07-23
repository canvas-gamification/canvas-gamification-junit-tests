package oop.programs_with_interesting_classes.medium.q5;

import java.util.regex.Pattern;

import java.util.Random;

public class PlayGame {
    public static void main(String[] args) {
        Hand hand1 = new Hand(dealHand());
        Hand hand2 = new Hand(dealHand());
        Hand hand3 = new Hand(dealHand());
        Hand hand4 = new Hand(dealHand());

        System.out.println("First Game: ");
        hand1.compareHand(hand2);

        System.out.println("Rematch: ");
        hand3.compareHand(hand4);
    }

    public static Card[] dealHand() {
        Card[] cards = new Card[5];
        Random r = new Random();

        for (int x = 0; x < 5; x++) {
            int suitSelector = r.nextInt(4);
            char suit;
            if (suitSelector == 0)
                suit = 'S';
            else if (suitSelector == 1)
                suit = 'C';
            else if (suitSelector == 2)
                suit = 'D';
            else
                suit = 'H';
            cards[x] = new Card(suit, r.nextInt(13) + 1);
        }

        return cards;
    }
}
