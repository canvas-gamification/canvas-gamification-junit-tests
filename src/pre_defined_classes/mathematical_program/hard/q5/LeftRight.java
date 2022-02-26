package pre_defined_classes.mathematical_program.hard.q5;

/*
Make a Java program to check the following trigonometric identity by displaying the value of the left hand side of the
equation as well as the right hand side of the equation:
sin( A + B ) = sin( A )cos( B ) + cos( A )sin( B ) where A and B are angles in radians.
 */
public class LeftRight {
    public static void main(String[] args) {
        double A = 2.56;
        double B = 1.47;
        double leftHandSide = Math.sin(A + B);
        double rightHandSide = Math.sin(A) * Math.cos(B) + Math.cos(A) * Math.sin(B);
        System.out.println("The leftHandSide is "+leftHandSide);
        System.out.println("The rightHandSide is "+rightHandSide);
    }

}
