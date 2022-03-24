package pre_defined_classes.mathematical_program.medium.q5;

/*
Java's Math class has the ability to calculate trigonometric values by using methods like <tt>cos()</tt> for the cosine
function and <tt>tan()</tt> for the tangent function. Using these functions, we can verify some well known
trigonometric identities. Make a Java program that verifies the following trigonometric identity: sec2() + tan2() = 1
where(theta) is the degree in radians and sec is a mathematical formula that calculates the length of the hypotenuse
divided by the length of the adjacent side. Note, the formula to obtain sec2()is : sec2()=1cos2()

Sample Output:
	The value of tan^2 is: 1
	The value of sec^2 is: 1
	Their sum is: 2
 */

public class TrigVal {
    public static void main(String[] args) {
        double degrees = 60.0;
        double theta = Math.toRadians(degrees);
        double tan2 = Math.pow(Math.tan(theta), 2);
        double cos2 = Math.pow(Math.cos(theta), 2);
        double sec2 = 1 / cos2;
        System.out.println("The value of tan^2 is: " + tan2);
        System.out.println("The value of sec^2 is: " + sec2);
        System.out.println("Their sum is: " + (tan2 + sec2));
    }
}
