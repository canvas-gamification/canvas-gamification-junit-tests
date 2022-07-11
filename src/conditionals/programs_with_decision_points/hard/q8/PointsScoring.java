package conditionals.programs_with_decision_points.hard.q8;

import java.util.Scanner;
public class PointsScoring
{
   public static void main( String [] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println("How many points did you score?");
      int score = input.nextInt();
      if( score >= 5000)
         System.out.println("You won a gold prize!");
      else if( score >=2500 && score < 5000)
         System.out.println("You won a silver prize!");
      else if( score >= 1000 && score < 2500)
         System.out.println("You won a bronze prize!");
      else 
         System.out.println("Sorry, you didn't win any prize.");
   }
}
