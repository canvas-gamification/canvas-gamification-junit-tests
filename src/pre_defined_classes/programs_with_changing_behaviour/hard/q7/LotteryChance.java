package pre_defined_classes.programs_with_changing_behaviour.hard.q7;

/*
Lotteries are events to randomly select a winner and reward that winner with a monetary prize. You've bought 4 lottery
tickets, and now you want to determine your chances of winning the lottery. To calculate the odds of winning the lottery,
you divide the number of tickets you bought by the total number of tickets sold. In this problem, we don't know the
total number of tickets sold, but we know it is a random number between 10,000 and 999,999 (inclusive of both values).
Make a Java program that prints the number of tickets you bought, generates and prints a random number for the total
number of lottery tickets, then determines the chance you have at winning the lottery and displays that as a percentage.

Sample output:
    You bought 4 tickets.
    The number of participants in the lottery is: 410177.
    Your chance of winning is: 9.751887599743525E-4%.

Distractors:
int totalTickets = 10000 + gen.nextInt( 999999 );
int totalTickets = gen.nextInt( 999999 );
double chanceOfWinning = (yourtickets/totalTickets)*100;
int chanceOfWinning = yourtickets/totalTickets;
double chanceOfWinning = totalTickets/yourTickets * 100;
count yourTickets = 4;
System.out.println( "The chance you have of winning the lottery is: " + yourTickets);

 */

import java.util.Random;

public class LotteryChance {
    public static void main(String[] args) {
        int yourTickets = 4;
        System.out.println("You bought " + yourTickets + " tickets.");
        Random gen = new Random();
        int totalTickets = 10000 + gen.nextInt(990000);
        System.out.println("The number of tickets in the lottery is: " + totalTickets + ".");
        double chanceOfWinning = (double) yourTickets / totalTickets;
        chanceOfWinning = chanceOfWinning * 100;
        System.out.println("Your chance of winning is: " + chanceOfWinning + "%.");
    }
}
