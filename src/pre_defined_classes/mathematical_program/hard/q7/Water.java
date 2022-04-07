package pre_defined_classes.mathematical_program.hard.q7;
/*
Given the depth of water at a certain point in the ocean, we can determine the speed in kilometers per hour (km/hr)
of a tsunami that originates at that point using the formula: speed = sqrt(depth*9.8). Make a Java program that
calculates the speed of a tsunami where the water depth is known.

double speed = Math.pow( ( depth * 9.8 ), 1/2 );
speed = Math.pow( ( depth * 9.8 ), 0.5 );
double speed = Math.root( ( depth * 9.8 ) );
double speed = Math.sqrt( ( depth x 9.8 ));
double depth, quantity, speed;
double quantity, speed;
quantity = depth * 9.8;
speed = Math.sqrt( quantity );
 */
public class Water {
    public static void main( String[] args )
    {
        int depth = 5;
        double quantity = depth * 9.8;
        double speed = Math.sqrt( quantity );
        System.out.println( "The speed of a tsunami is " + speed + "km/hr" );
    }

}
