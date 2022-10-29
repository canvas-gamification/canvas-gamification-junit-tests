package methods.defining_methods.hard.q9;

/*
Write a Java program asking the user for the number of courses they are taking right now. Then, create a method named
creditsCac that accepts the number of courses as an integer and returns an integer for credits the student will receive,
assuming that each course consists of three credits. Print the number of credits the user will receive in the main
method.

Sample Output:
  Enter the number of courses you're taking this year:
  3
  The number of credits you'll receive is 9
 */

import java.util.Scanner;

public class NumCoursesMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of courses you're taking this year:");
        int courses = input.nextInt();
        System.out.println("The number of credits you'll receive is " + creditsCalc(courses));
    }

    public static int creditsCalc(int coursesCount) {
        return 3 * coursesCount;
    }
}
