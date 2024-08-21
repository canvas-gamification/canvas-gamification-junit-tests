package oop.programs_with_interesting_classes.hard.q6;

import java.util.Random;
public class DeckOfCards
{
    private int maxRanks = 13;
    private int maxSuits = 4;
    private int maxCards = maxRanks * maxSuits;
    private Card[] deck;
    private int pos;

    public DeckOfCards()
    {
        deck = new Card[maxCards];
        pos = 0;
    }

    public void setMaxRanks(int maxRanks){
        if(maxRanks <= 13) {
            this.maxRanks = maxRanks;
            maxCards = maxRanks * maxSuits;
            deck = new Card[maxCards];
        }
        else
            System.out.println("Invalid value");
    }
    public void setMaxSuits(int maxSuits){
        if(maxSuits <= 4) {
            this.maxSuits = maxSuits;
            maxCards = maxRanks * this.maxSuits;
            deck = new Card[maxCards];
        }
        else
            System.out.println("Invalid value");
    }

    public void shuffleCards()
    {
        int[] possibleRanks = new int[maxRanks];
        Random gen = new Random();

        for(int i = 0; i< maxCards; i++ )
        {
            int r = gen.nextInt(maxRanks);
            while( possibleRanks[ r ] >= maxSuits)
                r = gen.nextInt(maxRanks);

            int myRank = r+1;
            possibleRanks[ r ]++;
            int mySuit = possibleRanks[ r ];

            Card myCard = new Card( myRank, mapSuitToString( mySuit ) );
            deck[i] = myCard;
        }
    }
    private String mapSuitToString( int suit )
    {
        String word;
        if( suit == 1 )       word = "Spades";
        else if( suit == 2 )  word = "Hearts";
        else if( suit == 3 )  word = "Clubs";
        else                  word = "Diamonds";
        return word;
    }
    public Card deal()
    {
        Card nextCard = null;
        if( pos < maxCards)
        {
            nextCard = deck[ pos ];
            pos++;
        }
        else
            System.out.println( "There are no more cards left in the deck." );
        return nextCard;
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i< maxCards; i++ )
            str += deck[i].toString() + "\n";
        return str;
    }
}

