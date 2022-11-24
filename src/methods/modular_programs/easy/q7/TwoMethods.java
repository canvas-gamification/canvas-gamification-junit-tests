package methods.modular_programs.easy.q7;

/*
Write a Java Program that asks the user for two double variables and performs two calculations with them, using two
methods. Firstly, take the first number and raise it to the second number using a method called raisedCalc.
Secondly, find the larger double number and convert that double to radians (assuming it is in degrees) using a method
called degreeCalc.

Sample output:
    Enter the first number:
    5.23
    Enter the second number:
    17.95
    The value of the first number raised to the second variable is 7.890514371332084E12
    The value of the larger number converted from degrees to radians is 0.31328660073298215
 */

import java.util.Scanner;

public class TwoMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double a = input.nextDouble();
        System.out.println("Enter the second number: ");
        double b = input.nextDouble();
        System.out.println("The value of the first number raised to the second number is " + raisedCalc(a, b));
        System.out.println("The value of the larger number converted from degrees to radians is " + degreeCalc(a, b));
    }

    public static double raisedCalc(double a, double b) {
        return Math.pow(a, b);
    }

    public static double degreeCalc(double a, double b) {
        if (a > b)
            return Math.toRadians(a);
        else
            return Math.toRadians(b);
    }
}
