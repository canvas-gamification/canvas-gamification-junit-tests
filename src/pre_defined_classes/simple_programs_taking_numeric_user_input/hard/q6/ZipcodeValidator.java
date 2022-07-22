package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q6;

import java.util.Scanner;

/*
An online e-commerce website uses zip codes to determine the rate of the shipment. Prior to doing so, it validates the
zip code by asking the user to re-submit the same zip code and double confirm the zip-code. Make a program that asks
the user to enter a zip code and confirms it, then displays both zip codes back to the user.
Note that American zip codes consist of 5 digits. Assume the provider will not ship to zip codes that start with 0,
so users should not enter zip codes that start with 0.


Sample Output:
    Enter a US zip code:
    12345
    Re-enter the US zip code:
    54321
    The first zip code is: 12345, and the second zip is: 54321

Distractors:
    double zipCode = input.nextInt();
    double zipCode = input.nextDouble();
    boolean zipCode = input.nextLine();
    String zipCode = input.nextLine();
    char zipCode = input.nextLine();

    double zipCodeSecond = input.nextInt();
    double zipCodeSecond = input.nextDouble();
    String zipCodeSecond = input.nextLine();
    boolean zipCodeSecond = input.nextLine();
    char zipCodeSecond = input.nextLine();
 */

public class ZipcodeValidator{
        public static void main( String[] args )
        {
            Scanner input = new Scanner( System.in );
            System.out.println( "Enter a US zip code: " );
            int zipCode = input.nextInt();
            System.out.println( "Re-enter the US zip code: " );
            int zipCodeSecond = input.nextInt();
            System.out.println( "The first zip code is: " + zipCode + ", and the second zip code is: " + zipCodeSecond );
        }
}
