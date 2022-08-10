package methods.defining_methods.medium.q4;

/*
Write a Java Program that asks users for the height and radius of a cylinder. Then, using a method called volumeCylinder,
determine the volume of the cylinder.

Sample output:
Please enter the height of the cylinder:
17
Please enter the radius of the cylinder:
2.5
The volume of the given cylinder is: 2269.800692218626
 */

import java.util.Scanner;
public class CylinderTime
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the height of the cylinder: ");
        double heightCylinder = input.nextDouble();
        System.out.println("Please enter the radius of the cylinder: ");
        double radiusCylinder= input.nextDouble();
        System.out.println("The volume of the given cylinder is: " + volumeCylinder(heightCylinder, radiusCylinder));
    }
    public static double volumeCylinder(double radius, double height)
    {
        return Math.PI*radius*radius*height;
    }
}
