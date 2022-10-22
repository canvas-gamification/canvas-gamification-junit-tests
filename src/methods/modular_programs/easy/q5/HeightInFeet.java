package methods.modular_programs.easy.q5;

/*
Write a program that asks users for their height in cm, then converts it to feet by dividing the centimeters by 30.48.
Create a method called heightConversion to do this, which should return the value in feet, or -1 of the entered height
is less than zero.

Sample output:
    Please enter your height in cm:
    138
    Your height in feet is: 4.526400000000001
 */

import java.util.Scanner;

public class HeightInFeet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your height in cm: ");
        double height = input.nextDouble();
        System.out.println("Your height in feet is: " + heightConversion(height));
    }

    public static double heightConversion(double a) {
        if (a < 0)
            return -1.0;
        else
            return a/30.48;
    }
}
