package methods.defining_methods.hard.q9;

/**
 * [J] Write a Java Program that asks users for the number of courses they are taking right now. A course will contain
 * 3 credits. Write a method named creditsCac that accepts the number of courses and returns the number of credits the student will receive.
 * 
 * Sample Output:
 *    Enter the number of courses you're taking this year:
 *    3
 *    The number of credits you'll receive is 9
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