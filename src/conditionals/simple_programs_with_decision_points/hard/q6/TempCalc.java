package conditionals.simple_programs_with_decision_points.hard.q6;

import java.util.Scanner;

/*
Write a program that will ask the user for their temperature and print out "You have a fever" when the temperature
exceeds or equals 100 oF.

Distractors:
Scanner input = new Scanner( System );
double temp = input.next();
if( temp > 100)
if( temp < 100)
if( temp <= 100)
if( temp == 100)
 */

public class TempCalc {
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter your current temperature ( in fahrenheit ): ");
        double temp = input.nextDouble();
        if( temp >= 100)
            System.out.println("You have a fever. Stay at home and rest.");
        else
            System.out.println("You don't have a fever. Have fun out there!");
    }

}
