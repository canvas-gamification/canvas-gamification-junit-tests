package methods.defining_methods.medium.q6;

/*
Create a Java Program that asks the user for the volume of a cube. Then, using a method called lengthCube, calculate
and return the length of a side of the cube. If the entered volume is negative, return -1.
Sample output:
Please enter the volume of a cube:
27
The side length of the given cube is: 3.0
 */

import java.util.Scanner;
public class VolToLength
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the volume of a cube: ");
        double volumeCube= input.nextDouble();
        System.out.println("The side length of the given cube is: " + lengthCube(volumeCube));
    }
    public static double lengthCube(double volume)
    {
        if(volume < 0)
            return -1;
        else
            return Math.cbrt(volume);
    }
}

