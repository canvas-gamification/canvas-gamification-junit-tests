package pre_defined_classes.mathematical_program.medium.q9;

/*
Java's Math class has the ability to calculate trigonometric values by using methods like <tt>sin()</tt> for the sine
function and <tt>cos()</tt> for the cosine function. Using these functions, we can verify some well known trigonometric
identities. Make a Java program that checks the following trigonometric identity: sin(2) = 2sin()cos() where 𝜽 is the
angle in radians.
 */

public class TrigIdentity {
    public static void main(String[] args) {
        double angleRadians = 3.42;
        double leftHandSide = Math.sin(2 * angleRadians);
        double rightHandSide = 2 * Math.sin(angleRadians) * Math.cos(angleRadians);
        System.out.println("The left hand side is " + leftHandSide);
        System.out.println("The right hand side is " + rightHandSide);
    }
}