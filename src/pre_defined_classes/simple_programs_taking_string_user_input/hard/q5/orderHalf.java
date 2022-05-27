package pre_defined_classes.simple_programs_taking_string_user_input.hard.q5;
/*
Some restaurant employees only write down the most important items of an order rather than writing down everything. At FakeOK
restaurant, the servers only write down the first half of the orders. To replicate this process, make a Java program to
ask for a customer's order, then only print out the first half of the input. Assume the user provides valid input.

Sample Output:
	Hello, welcome to FakeOK restaurant.
    What is your order?
    The French Dip with mushrooms, a side of fries, and gravy please.
    Great, I'll be back with: The French Dip with mushrooms, a

Distractors:
    System.out.println( "Hello, welcome to FakeKelowna restaurant. What is your order?" );
    String order = input.next();
    int half = order.length / 2;
    double half = ( int )( order.length() / 2 );
    System.out.println( "Great, I'll be back with: " + order.substring( 0, half );
    System.out.println( "Great, I'll be back with: " + order( 0, half ));

 */

import java.util.Scanner;

public class orderHalf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, welcome to FakeOK restaurant.");
        System.out.println("What is your order?");
        String order = input.nextLine();
        int half = order.length() / 2;
        System.out.println("Great, I'll be back with: " + order.substring(0, half));
    }
}
