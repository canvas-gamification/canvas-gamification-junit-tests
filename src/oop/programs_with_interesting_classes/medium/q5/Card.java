package oop.programs_with_interesting_classes.medium.q5;

public class Card {
    private char suit;
    private int rank;

    public Card(char suit, int rank) {
        if (suit == 'S' || suit == 'C' || suit == 'D' || suit == 'H')
            this.suit = suit;
        else
            this.suit = 'S';
        if (0 < rank && rank < 14)
            this.rank = rank;
        else
            this.rank = 1;
    }

    public char getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }
}
