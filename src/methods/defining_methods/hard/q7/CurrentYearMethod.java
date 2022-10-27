package methods.defining_methods.hard.q7;

/*
Write a Java Program that asks users for the number of days in the current year. Then write a method called leapChecker
that accepts that value as an integer and returns a boolean value if it is a leap year or not (true if it is, false if
not). The year is a leap year if it has 366 days. Lastly, if the method returns true, print "This year is a leap year",
if it is false, print "This year isn't a leap year".

Sample Output:
	Enter the number of days in this year:
	366
	This year is a leap year
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
