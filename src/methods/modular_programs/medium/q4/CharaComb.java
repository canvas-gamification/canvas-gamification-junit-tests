package methods.modular_programs.medium.q4;

/**
 * *[J] Write a program with a method called feverCheck that will ask the user
 * for their temperature and print out "You have a fever" when the temperature
 * exceeds 100 oF and "You don't have a fever" otherwise.
 * 
 * Sample Output:
 *  Enter your current temperature ( in fahrenheit ): 
 *  100
 *  You have a fever.
 */
import java.util.Scanner;

public class CharaComb {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your current temperature ( in fahrenheit ): ");
    double temp = input.nextDouble();
    feverCheck(temp);
  }

  public static void feverCheck(double temp) {
    if (temp >= 100)
      System.out.println("You have a fever.");
    else
      System.out.println("You don't have a fever.");
  }
}
