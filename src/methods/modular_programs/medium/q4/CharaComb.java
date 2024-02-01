package methods.modular_programs.medium.q4;

/**
 * *[J] Write a program with a method called feverCheck. The feverCheck method should get a double called temp and if
 * temp is more or equal than 100 it should print "You have a fever", otherwise it should print "You don't have a fever.".
 * The main method should get a double temp in input with the following format and call the feverCheck method.
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
