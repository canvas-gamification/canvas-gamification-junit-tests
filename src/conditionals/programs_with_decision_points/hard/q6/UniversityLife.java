package conditionals.programs_with_decision_points.hard.q6;

/*
 * Write a program that asks the user for their undergraduate year level and prints out their university status
 * using the following information: 1st year students are "Freshman", 2nd year students are "Sophomore", 3rd year
 * students are "Junior" and 4th year students are "Senior." Verify the user's input to make sure it is only these
 * 4 cases, and display the error message “Invalid Input!” in case they enter invalid input.
 * 
 * Sample Output:
 *    Which year are you in? (1, 2 , 3, or 4) ?
 *    1
 *    You're a Freshman
 * 
 * Distractors:
 *    if( year = 1 )
 *    else if( year = 2 )
 *    else if( year = 3 )
 *    else if( year = 4 )
 *    else if( year = 5 )
 *    else if( year = 6 )
 * 
 */

import java.util.Scanner;

public class UniversityLife
{
   public static void main( String [] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println("Which year are you in? (1, 2 , 3, or 4) ?");
      int year = input.nextInt();
      if( year == 1 )
         System.out.println("You're a Freshman");
      else if( year == 2 )
         System.out.println("You're a Sophomore");
      else if( year == 3 )
         System.out.println("You're a Junior");
      else if( year == 4 )
         System.out.println("You're a Senior");
      else 
         System.out.println("Invalid Input!");
   }
}
