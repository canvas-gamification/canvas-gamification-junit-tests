package pre_defined_classes.mathematical_program.hard.q3;
/*
Make a Java program that prints out the area of a sector of a circle. A sector of a circle is like a pizza slice.
Your program will be given the radius of the circle and the degrees of the sector which you will need to convert to radians.
Recall that the formula for the area of a sector of a circle is:
Area = (r^2)𝜃/2 where 𝜃 is in radians and r is the circle's radius.

Distractors:
int degreesOfSector = 59.7;
Double radius = 7;
int radiansOfSector = Math.toDegrees( degreesOfSector );
double area = ( radius * radiansOfSector ) / 2;
System.out.println( "The area of the sector is: + area");

 */
public class AreaSector {
    public static void main( String[] args )
    {
        int degreesOfSector = 58;
        int radius = 7;
        double radiansOfSector = Math.toRadians( degreesOfSector );
        double area = ( radius*radius*radiansOfSector )/2;
        System.out.println( "The area of the sector is: " + area );
    }

}
