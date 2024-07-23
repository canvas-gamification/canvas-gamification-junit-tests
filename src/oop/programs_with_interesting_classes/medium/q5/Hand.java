package oop.programs_with_interesting_classes.medium.q5;

public class Hand {
    private Card[] myCards;

    public Hand(Card[] set) {
        myCards = set;
    }

    public Card[] getMyCards() {
        return myCards;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < myCards.length - 1; i++)
            result += myCards[i].toString() + ", ";
        if (myCards.length > 0)
            result += myCards[myCards.length - 1].toString();
        return result;
    }

    public void compareHand(Hand other) {
        int hand1Max = 0;
        int hand2Max = 0;
        Card[] otherCards = other.getMyCards();
        for (int i = 0; i < myCards.length; i++) {
            if (myCards[i].getRank() > hand1Max)
                hand1Max = myCards[i].getRank();
            if (otherCards[i].getRank() > hand2Max)
                hand2Max = otherCards[i].getRank();
        }
        if (hand1Max > hand2Max)
            System.out.println("Winner: " + toString());
        else if (hand1Max < hand2Max)
            System.out.println("Winner: " + other.toString());
        else
            System.out.println("It's a tie!");
    }
}
