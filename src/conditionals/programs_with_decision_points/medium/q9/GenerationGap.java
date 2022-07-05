package conditionals.programs_with_decision_points.medium.q9;

/*
 * Write a program that will ask the user their birth year, verify that it is above 1900, and display the generation
 * they belong to based on the following information: "Baby Boomers" are born between 1944 and 1964, "Gen X" is born
 * between 1965 and 1979, "Millennials" are born between 1980 and 1994, and "Gen Z" is born between 1995 and 2015.
 * Anyone else is "Uncategorized." 
 * 
 * Sample output:
 *   Enter your birth year : 1944
 *   Baby Boomer
 */

import java.util.Scanner;

public class GenerationGap {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your birth year :");
    int by = input.nextInt();
    if (by > 1900) {
      if (by >= 1944 && by < 1965)
        System.out.println("Baby Boomer");
      else if (by >= 1965 && by < 1980)
        System.out.println("Gen X");
      else if (by >= 1980 && by < 1995)
        System.out.println("Millennial");
      else if (by >= 1995 && by < 2016)
        System.out.println("Gen Z");
      else
        System.out.println("Uncategorized");
    } else
      System.out.println("Invalid Input!");
  }
}
