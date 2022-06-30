package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q8;

/*
At the University of Fake Columbia, a student will not be allowed to write the final exam if the student's attendance
is less than 75%. Make a program that prompts the user to enter the total number of classes held and the total number
of classes attended, then prints out the percentage of classes the user attended.

Sample Output:
    How many classes were there?
    24
    How many classes did you attend?
    19
    You've attended 79% of the classes. You need 75% to pass.
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
        System.out.print("You've attended " + percentage + "% of the classes. You need 75% to pass.");

    }
}
