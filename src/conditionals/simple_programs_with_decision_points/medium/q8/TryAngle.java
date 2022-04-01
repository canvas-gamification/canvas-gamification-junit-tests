package conditionals.simple_programs_with_decision_points.medium.q8;
import java.util.Scanner;
/*
Write a program to ask for the three angles of a triangle and determine if it is a valid triangle or not.
(Note: Every triangle must have 3 angles whose sum is 180). Assume the user only enter numbers greater than 0.
Sample Output:
	Enter angle 1 in degrees: 90
	Enter angle 2 in degrees: 90
	Enter angle 3 in degrees: 90
How can you even have a perfectly closed 3-sided shape without the angles being 180???!!?
 */
public class TryAngle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter angle 1 in degrees: ");
        double a1 = input.nextDouble();
        System.out.println("Enter angle 2 in degrees: ");
        double a2 = input.nextDouble();
        System.out.println("Enter angle 3 in degrees: ");
        double a3 = input.nextDouble();
        if (a1 + a2 + a3 == 180)
            System.out.println("Now that's a valid triangle!");
        else
            System.out.println("How can you even have a perfectly closed 3-sided shape without the angles being 180???!!?");
    }
}
