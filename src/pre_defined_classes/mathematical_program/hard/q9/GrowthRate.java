package pre_defined_classes.mathematical_program.hard.q9;

/*
The rate of a population change that a country experiences is important for resource planning.
Part of this involves figuring out how fast the population grows, which we call the growth rate.
Mathematically, the formula to determine the population growth rate (in percent form) is defined as:
	Growth Rate =((Population2-Population1)/Population1)*100
where Population1 and Population2 are population sizes at two points in time.
With this, make a program to determine the growth rate of a country with Population1 = 32000 and Population2 = 50000
reported as a percentage.

 */
public class GrowthRate {
    public static void main( String[] args )
    {
        int population1 = 32000;
        int population2 = 50000;
        int numerator = population2-population1;
        double growthRate = (double) numerator/population1 * 100;
        System.out.println( "The growth rate for the country is:" + growthRate);
    }
}
