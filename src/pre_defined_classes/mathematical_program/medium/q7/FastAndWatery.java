package pre_defined_classes.mathematical_program.medium.q7;

/*
Given the depth of water at a certain point in the ocean, we can determine the speed of a tsunami in km/hr that
originates at that point using the formula: speed =depth9.8 . Make a java program that calculates the speed of a
tsunami where the water depth is 5000m.
 */

public class FastAndWatery
{
    public static void main( String[] args )
    {
        int depth = 5000;
        double speed = Math.sqrt( depth * 9.8 );
        System.out.println( "The speed of a tsunami starting at a depth of " + depth + " is " + speed + "km/hr." );
    }

}

