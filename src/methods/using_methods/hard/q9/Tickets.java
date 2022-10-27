package methods.using_methods.hard.q9;

/*
Write a Java Program called Tickets that asks users the number of people getting a ticket for a trip.
Your program should have a method called tripCostCalc that accepts the number of people as an input parameter and
returns the total cost of the tickets. If the number of tickets is less than 0, print 0. For two or fewer,
the cost of tickets is $5.00 per person; for 3-5 people, the price is $4.50 per person; for 6-10 people,
the price is $4.00 per person; for 11 or more people, the price is $3.00 per person.
Finally, print the total cost of the trip.
 */

import java.util.Scanner;
public class Tickets
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("How many people are going on the trip?");
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
