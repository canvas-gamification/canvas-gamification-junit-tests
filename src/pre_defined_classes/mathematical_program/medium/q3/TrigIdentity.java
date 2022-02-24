package pre_defined_classes.mathematical_program.medium.q3;

/*
Java's Math class has the ability to calculate trigonometric values by using methods like <tt>sin()</tt> for the sine
function and <tt>cos()</tt> for the cosine function. Using these functions, we can verify some well known trigonometric
 identities. Make a Java program that verifies the following trigonometric identity: sin2() + cos2() = 1 where(theta)
 is the degree in radians.
 */

public class TrigIdentity {
    public static void main(String[] args) {
        double degrees = 60.0;
        double theta = Math.toRadians(degrees);
        double sin2 = Math.pow(Math.sin(theta), 2);
        double cos2 = Math.pow(Math.cos(theta), 2);
        System.out.println("The value of sin^2 is: " + sin2);
        System.out.println("The value of cos^2 is: " + cos2);
        System.out.println("Their sum is: " + (sin2 + cos2));
    }
}

