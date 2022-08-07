package conditionals.programs_with_decision_points.medium.q8;

/*
 * Write a program that will ask the user for their placement and print out an "award" based on it using the following
 * information: 1st place gets a "Gold Trophy", 2nd place gets a "Silver Trophy", 3rd place  gets a "Bronze Trophy", and
 * everything below that receives a "Consolation Goodie Bag". The program should print "Invalid Input!" if the user enters
 * an invalid place (any number less than 1).
 * 
 * Sample output:
 *  Which place did you finish? (Ex. 1, 2, 3, etc): 
 *  1
 *  You won the Gold Trophy!
 */

import java.util.Scanner;

public class Competition {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Which place did you finish? (Ex. 1, 2, 3, etc):");
    int place = input.nextInt();
    if (place == 1)
      System.out.println("You won the Gold Trophy!");
    else if (place == 2)
      System.out.println("You won the Silver Trophy!");
    else if (place == 3)
      System.out.println("You won the Bronze Trophy!");
    else if (place >= 4)
      System.out.println("You won the Consolation Goodie Bag!");
    else
      System.out.println("Invalid Input!");
  }
}
