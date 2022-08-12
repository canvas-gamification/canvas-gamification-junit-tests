package methods.modular_programs.easy.q5;

/*
Write a Java Program that asks users for their height in cm, then convert that height in feet. Write a method to convert
it, or, if a negative input is given, return -1.0.
Sample output:
Please enter your height in cm:
138
Your height in feet is: 4.526400000000001

 */

import java.util.Scanner;
public class HeightInFeet
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your height in cm: ");
        double height = input.nextDouble();
        System.out.println("Your height in feet is: " + conversionHeight(height));
    }
    public static double conversionHeight(double a)
    {
        if(a < 0)
            return -1.0;
        else
            return a*(0.0328);
    }
}
