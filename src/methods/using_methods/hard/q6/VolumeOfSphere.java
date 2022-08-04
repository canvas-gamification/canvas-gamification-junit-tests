package methods.using_methods.hard.q6;

/*
Write a Java Program called VolumeOfSphere that asks the user for the radius of a sphere, and then write a method
called sphereVolume that accepts that value as an input parameter and returns the volume of the sphere.
If the radius is negative, the method should return -1.

Sample output:
Please enter the radius of the sphere:
3.14
The volume of the sphere is 129.68135913577137
 */

import java.util.Scanner;
public class VolumeOfSphere
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
        if(a < 0)
            return -1;
        else
            return (4/3.0)*Math.PI*Math.pow(a,3);
    }
}
