package conditionals.programs_with_decision_points.medium.q6;

/*
Write a program that takes only one lowercase character as a directional input from the user, either 'w', 'a', 's', or 'd'
and prints out a message depending on their input. The program should print "Jump" when the user enters 'w', "Crouch"
when the user enters 's', "Move Left" when they enter 'a', and "Move Right" if they enter 'd'. Also make sure to print
out an error message in case the user enters invalid input.

Sample Output:
  Enter w, a, s, or d :
  w
  Jump

*/

import java.util.Scanner;

public class Gamer {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter w, a, s, or d :");
    char inp = input.next().charAt(0); // Extracts the first character the user enters
    if (inp == 'w')
      System.out.println("Jump");
    else if (inp == 'a')
      System.out.println("Move Left");
    else if (inp == 's')
      System.out.println("Crouch");
    else if (inp == 'd')
      System.out.println("Move Right");
    else
      System.out.println("Invalid Input!");
  }
}
