package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q10;

/*
A Piper Saratoga is a hobby plane with six seats that has a capacity to hold 1200 pounds on a flight.
Make a program that helps this plane's pilot determine how much luggage can be brought on the return flight from
a vacation. The program needs to consider the weight of the travellers and the weight of the gas needed for the return
flight to determine the total weight allowance for luggage on the return flight.
Assuming users only enter valid inputs, meaning that the weight of the travellers must be >= 0 and that gas must be > 0.

Sample output:
    How much do all the travellers weigh in pounds?
    376
    How much does the gas weigh for the return flight in pounds?
    700
    You can board with and check in 124.0 pounds of luggage in total.

 */

import java.util.Scanner;

public class PiperSaratoga {
    public static void main( String[] argos )
    {
        final int MAX_CAPACITY = 1200;
        Scanner scan = new Scanner( System.in );
        System.out.println( "How much do all the travellers weigh in pounds?" );
        double people = scan.nextDouble();
        System.out.println( "How much does the gas weigh for the return flight in pounds?" );
        double gas = scan.nextDouble();
        double luggage = MAX_CAPACITY - people - gas;
        System.out.println( "You can have " + luggage + " pounds of luggage in total." );
    }

}
