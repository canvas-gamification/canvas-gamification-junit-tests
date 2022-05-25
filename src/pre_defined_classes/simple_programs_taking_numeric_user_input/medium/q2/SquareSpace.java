package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q2;

/*
Make a program that takes a number from the user and uses it to calculate the area and perimeter of a square.
Assume the user enters a valid positive integer.

Sample Output:
	Enter the length of the side of a square: 5
	The area is: 25
	The perimeter is: 20
 */

import java.util.Scanner;

public class SquareSpace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the side of a square: ");
        int side = input.nextInt();
        int area = side * side;
        int perimeter = side * 4;
        System.out.println("The area is: " + area);
        System.out.println("The perimeter is: " + perimeter);
    }
}

