package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q2;
/*
Suppose an airline is looking into automating its check-in process at the airport, and you are the developer for that
program. Make a program that asks the passengers how many bags they are checking in. As passengers are required to pay
$25 for each checked bag, the program will display the baggage fee to the passengers. Assume that the user only enters
non-negative integers.

Sample Output:
	How many bags are you checking in? 2
    The baggage fee is $50

Distractors:
    Scanner input = new Scanner( System.output );
    System.out.print( How many bags are you checking? );
    int numBags = input.nextDouble();
    boolean fee;
    fee = 25 % numBags;
    System.out.println( "The baggage fee is " + $fee );
 */

import java.util.Scanner;

public class AirlineBaggage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many bags are you checking in? ");
        int numBags = input.nextInt();
        int fee;
        fee = 25 * numBags;
        System.out.println("The baggage fee is $" + fee);
    }
}
