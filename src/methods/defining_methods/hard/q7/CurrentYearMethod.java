package methods.defining_methods.hard.q7;

/**
 * [J] Write a Java Program that asks users for the number of days in the current year. Then write a
 * method that accepts that value and returns a boolean value if it is a leap year or not (true if it
 * is a leap year, false if not). Let’s call the method “leapChecker”.
 * 
 * Sample Output:
 *    Enter the number of days in this year:
 *    366
 *    This year is a leap year
 */

import java.util.Scanner;

public class CurrentYearMethod {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number of days in this year:");
    int dayYears = input.nextInt();
    boolean checker = leapChecker(dayYears);
    if (checker)
      System.out.println("This year is a leap year");
    else
      System.out.println("This year isn't a leap year");
  }

  public static boolean leapChecker(int days) {
    return days == 366;
  }
}
