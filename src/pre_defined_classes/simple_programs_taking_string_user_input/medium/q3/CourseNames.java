package pre_defined_classes.simple_programs_taking_string_user_input.medium.q3;
/*
Make a program that asks the user to enter two university course names and displays them on the same line. Assume the user
enters valid input.
Sample Output:
	Enter the name of the first course: COSC-111
	Enter the name of the second course: COSC-121
	The courses are: COSC-111 and COSC-121

 */

import java.util.Scanner;

public class CourseNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the first course: ");
        String course1 = input.next();
        System.out.println("Enter the name of the second course: ");
        String course2 = input.next();
        System.out.println("The courses are: " + course1 + " and " + course2);
    }
}
