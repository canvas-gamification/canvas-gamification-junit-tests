package methods.using_methods.hard.q8;

/*
Write a Java Program called Celverter that asks users for the current temperature in Celsius,
then write a method called tempCalc that accepts that value as an input parameter and returns the temperature in Fahrenheit.
The program should print the converted temperature. 
Sample output:
What is the current temperature in Celsius?
19
The current temperature in Fahrenheit is 66.2
 */

import java.util.Scanner;
public class Celverter
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the current temperature in Celsius?");
        double currentTemp= input.nextDouble();
        System.out.println("The current temperature in Fahrenheit is " + tempCalc(currentTemp));
    }
    public static double tempCalc(double a)
    {
        return a*(9.0/5)+32;
    }
}
