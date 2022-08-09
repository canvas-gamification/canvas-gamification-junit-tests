package methods.modular_programs.medium.q2;
/*
Write a Java Program that asks the user for the temperature in Fahrenheit, and then write a method called tempConversion
that converts it into Celsius. After the conversion, print the temperature in the main method. The conversion from
Fahrenheit to Celsius is Celsius = (Fahrenheit - 32) * (5/9).

Sample Output:
    Enter the temperature in Fahrenheit:
    39
    The temperature in Celsius is 3.8891999999999998

Distractors:
    Scanner in = new System(Scanner.in);
    Import JAVA.util.Scan
    int userTemp = in.nextDouble();
    Double userTemp = input.next();
    return fahrenheit-32;
    return fahrenheit*0.5556

 */

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the temperature in Fahrenheit: ");
        double userTemp = input.nextDouble();
        System.out.println("The temperature in Celsius is " + tempConversion(userTemp));
    }

    public static double tempConversion(double fahrenheit) {
        return (fahrenheit - 32) * (5.0 / 9);
    }
}
