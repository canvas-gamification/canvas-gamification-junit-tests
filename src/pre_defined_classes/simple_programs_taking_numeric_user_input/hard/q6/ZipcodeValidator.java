package pre_defined_classes.simple_programs_taking_numeric_user_input.hard.q6;

import java.util.Scanner;

/*
An online e-commerce website uses zip codes to determine the rate of the shipment. Prior to doing so, it validates the
zip code by asking the user to re-submit the same zip code and double confirm the zip-code. Make a program that asks
the user to enter a zip code and confirm it, then display out both zip codes back to the user.
Note that American zip codes consist of 5 digits.


Sample Output:
    Enter a US zip code:
    12345
    Re-enter the US zip code:
    54321
    The first zip code is: 12345, and the second zip is: 54321

    Enter a US zip code:
    123
    Re-enter the US zip code:
    123
    The first zip code is: 123, and the second zip is: 123

    Enter a US zip code:
    01234
    Re-enter the US zip code:
    01234
    The first zip code is: 1234, and the second zip is: 1234
    //the data type of the input should be String type instead
    >> okay changed to .nextLine(). Actually, nah, if I changed to a string question, this question should be under pre_defined_classes-simple_programs_taking_string_user_input
    >> I changed ZipcodeValidator.java & MainTest.java (take string input). The google doc is still takes int input just in case.

Distractors:
    double zipCode = input.nextInt();
    double zipCode = input.nextDouble();
    boolean zipCode = input.nextLine();
    String zipCode = input.nextLine(); //this currently passes
    char zipCode = input.nextLine();

    double zipCodeSecond = input.nextInt();
    double zipCodeSecond = input.nextDouble();
    String zipCodeSecond = input.nextLine(); //this currently passes
    boolean zipCodeSecond = input.nextLine();
    char zipCodeSecond = input.nextLine();
 */

public class ZipcodeValidator{
        public static void main( String[] args )
        {
            Scanner input = new Scanner( System.in );
            System.out.println( "Enter a US zip code: " );
            String zipCode = input.nextLine();
            System.out.println( "Re-enter the US zip code: " );
            String zipCodeSecond = input.nextLine();
            System.out.println( "The first zip code is: " + zipCode + ", and the second zip code is: " + zipCodeSecond );
        }
}
