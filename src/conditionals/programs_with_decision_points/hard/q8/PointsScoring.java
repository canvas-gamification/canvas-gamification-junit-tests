package conditionals.programs_with_decision_points.hard.q8;

/*
 * Write a Java Program that asks a player for their score, and prints out the prize that a player wins in a game
 * depending on their score. If the player scores 5000 points or above, they win a gold prize. If the player scores
 * between 2500 - 4999 points, they win a silver prize. If the player scores between 1000 - 2499 points, they win a
 * bronze prize. If they score below 1000 points, they don't win any prize. Make sure to print out an error message if 
 * the player enters an invalid score.
 * 
 * Sample output:
 *    How many points did you score?
 *    5000
 *    You won a gold prize!
 * 
 * Distractors:
 *    String score = input.nextInt();
 *    if( score > 5000 )
 *    else if( score > 2500 && score <= 5000 )
 *    else if( score > 1000 && score <= 2500 )
 * 
 */

import java.util.Scanner;
public class PointsScoring
{
   public static void main( String [] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println("How many points did you score?");
      int score = input.nextInt();
      if (score >= 0) {
         if( score >= 5000)
            System.out.println("You won a gold prize!");
         else if( score >=2500 && score < 5000)
            System.out.println("You won a silver prize!");
         else if( score >= 1000 && score < 2500)
            System.out.println("You won a bronze prize!");
         else 
            System.out.println("Sorry, you didn't win any prize.");
      } else {
         System.out.println("Invalid Input!");
      }
   }
}
