package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q10;

/*
A Piper Saratoga is a hobby plane with six seats that has a capacity to hold 1200 pounds on a flight.
 Make a program that helps this plane's pilot determine how much luggage can be brought on the return flight from
 a vacation. The program needs to consider the weight of the travellers, the weight of the gas needed for the return
 flight, and the weight of the luggage for the trip. Finally, the program will display the weight allowable for
 bringing souvenirs home on the return flight.

Sample output:
    How much do all the travellers weigh?
    376
    How much does the gas weigh for the return flight?
    700
    How much luggage are you bringing and what does it weigh?
    150
    You can bring back 324.0 pounds of souvenirs!

    //huh?
    How much do all the travellers weigh?
    510
    How much does the gas weigh for the return flight?
    800
    How much luggage are you bringing and what does it weigh?
    300
    You can bring back -10.0 pounds of souvenirs!

    //huh?
    How much do all the travellers weigh?
    1200
    How much does the gas weigh for the return flight?
    1200
    How much luggage are you bringing and what does it weigh?
    12 1200
    You can bring back -612.0 pounds of souvenirs!
 */

import java.util.Scanner;

public class PiperSaratoga {
    public static void main( String[] argos )
    {
        final int MAX_CAPACITY = 1200;
        Scanner scan = new Scanner( System.in );
        System.out.println( "How much do all the travellers weigh?" );
        double people = scan.nextDouble();
        System.out.println( "How much does the gas weigh for the return flight?" );
        double gas = scan.nextDouble();
        gas = gas / 2;
        System.out.println( "How much luggage are you bringing and what does it weigh?" );
        double bags = scan.nextDouble();
        double gifts = MAX_CAPACITY - people - gas - bags;
        System.out.print( "You can bring back " + gifts + " pounds of souvenirs!" );
    }

}
