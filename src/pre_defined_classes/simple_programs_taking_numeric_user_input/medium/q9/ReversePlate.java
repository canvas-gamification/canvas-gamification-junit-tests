package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q9;

/*
Traffic speed cameras are used to catch drivers who speed. One of the issues with this system is that it reads the plate
 numbers backwards. For simplicity, suppose that all the plates are 3 digits long.
 Make a program to reverse an inputted plate number.

Sample output:
    What is the 3 digit plate number?
    678
    The reverse number is: 876
 */

import java.util.Scanner;

public class ReversePlate {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "What is the 3 digit plate number?" );
        int plateNum = input.nextInt();
        int num1 = plateNum / 100;
        plateNum = plateNum % 100;
        int num2 = plateNum / 10;
        int num3 = plateNum % 10;
        int reversePlate = num3 * 100 + num2 * 10 + num1;
        System.out.print( "The reverse number is: " + reversePlate );
    }

}
