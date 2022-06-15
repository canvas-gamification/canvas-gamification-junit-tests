package methods.using_methods.hard.q2;
/*
Write a Java Program that asks the user for an angle in degrees, and make a method that takes that value as an input
parameter and returns that angle in radians. The program should then print out this angle.
Sample Output
	Please enter the angle in degrees:
    180
    The angle in radians is: 3.141592653589793

 */

import java.util.Scanner;

public class Angles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the angle in degrees:");
        int degree = input.nextInt();
        System.out.println("The angle in radians is: " + degreeCalc(degree));
    }

    public static double degreeCalc(int a) {
        double x = Math.toRadians(a);
        return x;
    }
}
