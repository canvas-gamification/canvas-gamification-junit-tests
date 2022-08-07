package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q8;

/*
At the University of Fake Columbia, a student will not be allowed to write the final exam if the student's attendance
is less than 75%. Make a program that calculates the attendance percentage and notifies the user if they are failing
the course. To do that the program prompts the user to enter the total number of classes held and the total number of
classes attended, then prints out the percentage of classes the user attended.
Assume all user inputs valid (total number of classes must be greater than 0).

Sample Output:
    How many classes were there?
    24
    How many classes did you attend?
    19
    You've attended 79% of the classes and you need 75% to write the final exam.

 */

import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many classes were there?");
        int numClasses = input.nextInt();
        System.out.println("How many classes did you attend?");
        int attendedClasses = input.nextInt();
        int percentage = attendedClasses * 100 / numClasses;
        System.out.println("You've attended " + percentage + "% of the classes and you need 75% to write the final exam.");
    }
}
