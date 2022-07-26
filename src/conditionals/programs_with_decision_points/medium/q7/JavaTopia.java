package conditionals.programs_with_decision_points.medium.q7;

/*
 * In the imaginary land of "Javatopia", the first two digits of the 5-digit ZIP code determine
 * which district a certain address falls under. Write a java program to accept a 5-digit Javatopia ZIP code,
 * extract the first 2 digits and display which district it belongs to based on the following information:
 * ZIP codes that start with "12" belong to "String Avenue", ones that start with "14" belong to "Character County",
 * those that start with "22" belong to "Memory Front", and those that start with "24" belong to "RAM Ranch."
 * Anything else is outside the territory of Javatopia, the program should print "This ZIP code does not belong
 * to Javatopia". Make sure to verify that the ZIP code is exactly 5-digits long, and print an error message if it is not. Assuming the user always provides
 * an integer with no leading zero.
 * 
 * Sample output:
 *   Enter a Javatopia ZIP code:
 *   12345
 *   That ZIP code belongs to String Avenue
 */

import java.util.Scanner;

public class JavaTopia {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a Javatopia ZIP code:");
    int zip = input.nextInt();
    if (zip > 9999 && zip <= 99999) {
      int z = zip / 1000; // Extract the first two digits
      if (z == 12)
        System.out.println("This ZIP code belongs to String Avenue");
      else if (z == 14)
        System.out.println("This ZIP code belongs to Character County");
      else if (z == 22)
        System.out.println("This ZIP code belongs to Memory Front");
      else if (z == 24)
        System.out.println("This ZIP code belongs to RAM Ranch");
      else
        System.out.println("This ZIP code does not belong to Javatopia");
    } else
      System.out.println("Invalid Input!");
  }
}
