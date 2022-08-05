package methods.using_methods.hard.q9;

/*
Write a Java Program called Tickets that asks users the number of people getting a ticket for a trip.
Normally, if 2 or less people are getting tickets, the cost is $5 per person. If the number of people getting tickets
is 3-5 people, then the cost is $4.5 per person. If the number of people getting tickets is 6-10 people,
then the cost is $4 per person. If the number of people getting tickets is 11 or more, then the cost is $3 per person.
Write a Java Method called tripCostCalc that accepts the number of people as an input parameter and returns the
total cost of the tickets.
 */

import java.util.Scanner;
public class Tickets
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many people are going on the trip:");
        int numPeople = input.nextInt();
        System.out.println("The total cost of the trip is " + tripCostCalc(numPeople));
    }
    public static double tripCostCalc(int a)
    {
        if(a<=0)
            return 0;
        else if (a<=2)
            return a*5;
        else if (a<=5)
            return a*4.5;
        else if (a<=10)
            return a*4;
        else
            return a*3;
    }
}
