package oop.programs_with_interesting_classes.hard.q6;

import java.util.Scanner;

public class War
{
    public static void main( String[] args )
    {
        DeckOfCards cards = new DeckOfCards();

        Scanner input = new Scanner( System.in );
        String answer = "Y";
        while( answer.charAt( 0 ) == 'Y' )
        {
            cards.shuffleCards();

            Card myCard = cards.deal();
            System.out.println( "My card: " + myCard.toString() );
            Card yourCard = cards.deal();
            System.out.println( "Your card: " + yourCard.toString() );

            boolean mineBigger = myCard.isBiggerThan( yourCard );
            if( mineBigger )
                System.out.println( "I win!" );
            else
                System.out.println( "I did not win!" );

            System.out.println( "Want to play again? (Y/N)" );
            answer = input.nextLine();
        }
    }
}
