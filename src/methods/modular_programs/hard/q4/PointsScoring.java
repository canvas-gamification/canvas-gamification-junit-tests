package methods.modular_programs.hard.q4;

/**
 * Write a Java Program with a method called pointsScored that asks a player for
 * their score, and returns the prize that a player wins in a game depending
 * on their score. If the player scores 5000 points or above, they win a gold
 * prize. If the player scores between 2500 - 4999 points, they win a silver
 * prize. If the player scores between 1000 - 2499 points, they win a bronze
 * prize. If they score below 1000 points, they don't win any prize.
 * 
 * Sample Output:
 *  How many points did you score?
 *  5000
 *  You won a gold prize!
 */
import java.util.Scanner;

public class PointsScoring {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many points did you score?");
    int score = input.nextInt();
    System.out.println(pointsScored(score));
  }

  public static String pointsScored(int score) {
    if (score >= 5000)
      return "You won a gold prize!";
    else if (score >= 2500 && score < 5000)
      return "You won a silver prize!";
    else if (score >= 1000 && score < 2500)
      return "You won a bronze prize!";
    else
      return "Sorry, you didn't win any prize.";
  }
}
