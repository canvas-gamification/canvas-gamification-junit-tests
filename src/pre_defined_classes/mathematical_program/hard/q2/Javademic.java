package pre_defined_classes.mathematical_program.hard.q2;

/*
Make a program to calculate the time it takes for a pandemic to reach some number of infections.
In particular, given a growth rate of r = 0.39, an initial number of infected cases of x0= 2,
and an outbreak of xt= 1,000,000, use the following equation to determine how many days it takes to reach
1,000,000 infected cases: t = log(xt/x0)/log(1 + r).

Distractors:
 int xt = 1,000,000, x0 = 2; breaks
double t = Math.exp( xt / x0 ) / Math.exp( 1 + r ); Infinity
int t = Math.exp( xt / x0 ) / Math.exp( 1 + r ); breaks
int t = ( int )Math.exp( xt / x0 ) / Math.exp( 1 + r ); breaks
int t = ( double )( Math.exp( xt / x0 ) / Math.exp( 1 + r )); breaks
int t = Math.round( numerator / denominator ); breaks
double numerator = log( xt / x0 ); breaks
double denominator = log( 1 + r ); breaks
 */

public class Javademic {
    public static void main(String[] args) {
        double r = 0.39;
        int xt = 1000000;
        int x0 = 2;
        double numerator = Math.log( xt / x0 );
        double denominator = Math.log( 1 + r );
        int t = ( int )Math.round( numerator / denominator );
        System.out.println( "It will take " + t + " days to infect " + xt + " people" );

    }
}
