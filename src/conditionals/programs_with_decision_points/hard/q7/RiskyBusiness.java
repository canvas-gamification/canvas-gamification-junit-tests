package conditionals.programs_with_decision_points.hard.q7;

/*
 * Write a program that asks the user to enter the number of people present in a certain area, and display the
 * approximate risk of disease transmission based on the following information: Less than 1000 people is "Low Risk",
 * Between 1000 and 10000 people is "Moderate Risk", above 10000 people is "High Risk." Make sure to display an error
 * message if the user provides an invalid input (numbers less than or equal to 0).
 * 
 * Sample Output:
 *    How many people are in your area?
 *    1000
 *    Moderate Risk
 * 
 * Distractors:
 *    if( popDen > 0 || popDen < 1000)
 *    {
 *    }
 *    else if( popDen > 10000 )
 *    else if(  popDen >= 1000 || popDen < 10000)
 *    else if(  popDen > 1000 && popDen < 10000)
 * 
 */

import java.util.Scanner;

public class RiskyBusiness {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many people are in your area?");
    int popDen = input.nextInt();
    if (popDen > 0 && popDen < 1000)
      System.out.println("Low Risk");
    else if (popDen >= 1000 && popDen < 10000)
      System.out.println("Moderate Risk");
    else if (popDen >= 10000)
      System.out.println("High Risk");
    else
      System.out.println("Invalid Input!");
  }
}
