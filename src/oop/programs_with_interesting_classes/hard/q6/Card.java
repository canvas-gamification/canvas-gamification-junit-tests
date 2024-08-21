package oop.programs_with_interesting_classes.hard.q6;

public class Card {
    private int rank;
    private String suit;
    public Card( int i, String s )
    {
        rank = i;
        suit = s;
    }
    public int getRank() { return rank; }
    public String getSuit() { return suit; }
    public boolean isBiggerThan( Card c1 )
    {
        int ourRank = rank == 1 ? 1000 : rank;
        int theirRank = c1.getRank() == 1 ? 1000 : c1.getRank();
        return ourRank > theirRank;
    }
    public String toString()
    {
        String str = "";
        if( rank == 1 )
            str += "A";
        else if( rank > 1 && rank <= 10 )
            str += rank;
        else if( rank == 11 )
            str += "J";
        else if( rank == 12 )
            str += "Q";
        else
            str += "K";
        str += " of " + suit;
        return str;
    }
}
