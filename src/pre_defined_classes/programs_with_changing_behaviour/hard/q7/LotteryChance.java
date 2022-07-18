package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

/*
Lotteries are events held to randomly select a winner, and then rewarding that winner with a monetary prize. You've
bought 4 lottery tickets, and now you want to determine your chances of winning the lottery. To do this, you need to
divide the number of tickets you've bought by the total number of tickets that have been bought by everyone.
In this problem, we don't know the exact total number of lotteries bought, but we know it is a random number
between 10000 and 999999 (inclusive of both values). Make a Java program that determines that chance you have
at winning the lottery and displays that as a percentage.

Sample output:
Your chance of winning is: 8.619073578876375E-4

Distractors:
int totalParticipants = 10000+ gen.nextInt( 999999 );
int totalParticipants = gen.nextInt( 999999 );
double chanceOfWinning = (yourtickets/totalParticipants)*100;
int chanceOfWinning = yourtickets/totalParticipants;
double chanceOfWinning = totalParticipants/yourTickets * 100;
count yourTickets = 4;
System.out.println( "The chance you have of winning the lottery is: " + yourTickets);

 */

import java.util.Random;

public class LotteryChance {
    public static void main( String[] args )
    {
        int yourTickets = 4;
        Random gen = new Random();
        int totalParticipants = 10000+ gen.nextInt( 990000 );
        double chanceOfWinning = (double) yourTickets/totalParticipants;
        chanceOfWinning = chanceOfWinning * 100;
        System.out.println( "Your chance of winning is: " + chanceOfWinning );
    }
}
