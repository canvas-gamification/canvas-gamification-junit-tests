package pre_defined_classes.programs_with_changing_behaviour.medium.q6;

/*
You are playing a game where you are in control of a robot that has to traverse a maze. After playing the game for some
time, you've reached a crossroads, with 4 possible pathways that the robot can go through, and so you're confused as to
which path to take. Make a Java program that helps you decide a path. In particular, generate a random integer
from 0 to 999999 (exclusive of both values), then take the remainder of the random number divided by the number of
paths there are to choose from and display that path.

Sample output:
The path you've chosen to go is #2

 */

import java.util.Random;

public class ShuffleMovement {
    public static void main( String[] args )
    {
        Random gen = new Random();
        int randomVal = gen.nextInt( 999998 ) + 1;
        int pathWay = randomVal % 4;
        System.out.println( "The path you've chosen to go is #" + pathWay );
    }
}
