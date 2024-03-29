package methods.defining_methods.hard.q3;

/*
Write a Java Program that asks the user for the number of sides on a polygon, then determines the sum of the measure of
the interior angles of that polygon. Remember that the formula to determine the sum of interior angles is (n-2)*180,
where n is the number of sides. Create a method called "innerAngles(int size)" that takes the number of sides and
returns an integer as the sum of the interior angles. If the passed integer is less than 3, return -1.

Sample output:
	Enter the number of sides on the polygon:
	8
	The sum of interior angles of the polygon is: 1080
 */

import java.util.Scanner;

public class Polygo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of sides on the polygon:");
        int countSides = input.nextInt();
        System.out.println("The sum of interior angles of the polygon is: " + innerAngles(countSides));

    }

    public static int innerAngles(int a) {
        if(a < 3)
            return -1;
        else {
            int x = (a - 2) * 180;
            return x;
        }
    }
}
