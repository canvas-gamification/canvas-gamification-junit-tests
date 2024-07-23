package oop.programs_with_interesting_classes.medium.q6;

public class RaceTrack
{
    public static void main( String[] args )
    {
        //fastest probably fake video has about 12 acceleration speed, max speed 89 km/h
        Horse animal1 = new Horse("Betsy", 38.2, 5.1, 55);
        Horse animal2 = new Horse("Gerald", 34.7, 4.3, 63);
        double distance = 2.5;
        if( animal1.completionTime(distance) < animal2.completionTime(distance) )
            System.out.print(animal1.getName() + " is the WINNER!");
        else
            System.out.print(animal2.getName() + " is the WINNER!");
    }
}
