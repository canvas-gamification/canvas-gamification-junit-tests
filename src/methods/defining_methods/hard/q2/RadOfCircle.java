package methods.defining_methods.hard.q2;
/*
Write a Java Program that asks the user for the radius of a circle as a double and then determines the area and
circumference of the circle. Create two methods, one for the area called areaCalc, and one for the circumference called
circCalc, each of which should accept a double value as a parameter for the radius of a circle. The formula for the area
of a circle is area = pi * radius^2 and the formula for the circumference of a circle is circumference = 2 * pi * radius.
Make sure the methods check if the parameter passed in is greater than 0, and return 0 if it is not. The main method of
the program should also output the calculated area and circumference to two decimal places using printf. Ensure that your
output matches the sample.

Sample Output:
    Enter the radius of the circle:
    5
    The area of the circle is: 78.54
    The circumference of the circle is: 31.42
 */

import java.util.Scanner;

public class RadOfCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        double radius = input.nextDouble();
        System.out.printf("The area of the circle is: %.2f\n", areaCalc(radius));
        System.out.printf("The circumference of the circle is: %.2f\n", circCalc(radius));
    }

    public static double areaCalc(double a) {
        if (!(a > 0))
            return 0;
        double x = Math.PI * Math.pow(a, 2);
        return x;
    }

    public static double circCalc(double a) {
        if (!(a > 0))
            return 0;
        double x = Math.PI * 2 * a;
        return x;
    }
}
