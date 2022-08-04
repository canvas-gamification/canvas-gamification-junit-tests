package methods.using_methods.hard.q6;

/*
Write a Java Program called Using6 that asks the user for the radius of a sphere, and then write a method
called sphereVolume that accepts that value as an input parameter and returns the volume of the sphere.

Sample output:
Please enter the radius of the sphere:
3.14
The volume of the sphere is 129.68135913577137
 */

import java.util.Scanner;
public class Using6
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the radius of the sphere:");
        double radius= input.nextDouble();
        System.out.println("The volume of the sphere is " + sphereVolume(radius));
    }
    public static double sphereVolume(double a)
    {
        return (4/3.0)*Math.PI*Math.pow(a,3);
    }
}
