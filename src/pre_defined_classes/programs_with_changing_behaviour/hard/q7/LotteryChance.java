package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

/*
Lotteries are events held to randomly select a winner, and then rewarding that winner with a monetary prize. You've
bought 4 lottery tickets, and now you want to determine your chances of winning the lottery. To do this, you need to
divide the number of tickets you've bought by the total number of tickets that have been bought by everyone.
In this problem, we don't know the exact total number of lotteries bought, but we know it is a random number
between 10,000 and 999,999 (inclusive of both values). Make a Java program that prints the number of tickets you bought,
generates and prints a random number of lottery participants, nad then determines that chance you have at winning the
lottery and displays that as a percentage.

Sample output:
You bought 4 tickets.
The number of participants in the lottery is: 410177.
Your chance of winning is: 9.751887599743525E-4%.

Distractors:
int totalParticipants = 10000 + gen.nextInt( 999999 );
int totalParticipants = gen.nextInt( 999999 );
double chanceOfWinning = (yourtickets/totalParticipants)*100;
int chanceOfWinning = yourtickets/totalParticipants;
double chanceOfWinning = totalParticipants/yourTickets * 100;
count yourTickets = 4;
System.out.println( "The chance you have of winning the lottery is: " + yourTickets);

 */

import java.util.Random;

public class LotteryChance {
    public static void main(String[] args) {
        int yourTickets = 4;
        System.out.println("You bought " + yourTickets + " tickets.");
        Random gen = new Random();
        int totalParticipants = 10000 + gen.nextInt(990000);
        System.out.println("The number of participants in the lottery is: " + totalParticipants + ".");
        double chanceOfWinning = (double) yourTickets / totalParticipants;
        chanceOfWinning = chanceOfWinning * 100;
        System.out.println("Your chance of winning is: " + chanceOfWinning + "%.");
    }
}
