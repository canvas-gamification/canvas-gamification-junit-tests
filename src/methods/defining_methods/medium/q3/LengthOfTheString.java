package methods.defining_methods.medium.q3;

/*
Write a Java Program that asks the user for a sentence, then takes that input and calculates the length of the string.
Write a method called stringLenCalc that accepts the user's string and returns an int value of the length.

Sample output:
Please enter a sentence:
fifty bottles of milk on the wall
The length of your sentence is: 33
 */

import java.util.Scanner;
public class LengthOfTheString
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a sentence: ");
        String userInput = input.nextLine();
        System.out.println("The length of your sentence is: " + stringLenCalc(userInput));
    }
    public static int stringLenCalc(String a)
    {
        return a.length();
    }
}
