package methods.using_methods.hard.q7;

/*
Write a Java Program called Using7 that asks users for the length of a side of a cube,
then write a method called cubeVolume that accepts that value as an input parameter and returns the volume of the cube.

Sample output:
Please enter the length of a side:
4.5
The volume of the cube is 91.125
 */

import java.util.Scanner;
public class Using7
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the length of a side:");
        double sideLength= input.nextDouble();
        System.out.println("The volume of the cube is " +cubeVolume(sideLength));
    }
    public static double cubeVolume(double a)
    {
        return a*a*a;
    }
}
