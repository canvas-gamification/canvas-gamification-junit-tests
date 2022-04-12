package pre_defined_classes.mathematical_program.hard.q1;

/*
Make a program to calculate the growth in the number of cases (xt) for a pandemic at a given time <tt>t</tt> using the
equation: xt= (1+r)t x0, where r = 0.3 is the rate of growth, the initial number of people infected is x0= 5. Your
program will calculate how many people are going to be infected in t = 30 days.
Distractions:
double xt = (( 1 + r ) * t ) + x0;
import java.util.Math;
int r = 0.3;
double xt = Math.pow( quantity, x0 );
double quantity = Math.exp( 1+r, t );
double xt = Math.exp(( 1 + r ), t) * x0;
 */

public class Javademic {
    public static void main( String[] args )

    {
        double r = 0.3;
        int t = 30;
        int x0 = 5;
        double quantity = Math.pow( 1+r, t );
        double xt = quantity * x0;
        System.out.println( "Num cases of infections in " + t + " days is " + xt + " people" );
    }
}
