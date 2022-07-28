package loops.programs_with_repetition.easy.q4;

/*
 * Write a program to keep asking the user to enter a number until they enter a prime number that is lesser than 50. Make sure your output matches the sample. 
 * Note that prime numbers should not be negative. 
 * Sample output:
 *    Enter an integer:
 *    1
 *    Enter an integer:
 *    6
 *    Enter an integer:
 *    50
 *    Enter an integer:
 *    2
 *    Entered a prime number that is less than 50. Ending Program.
 */

import java.util.Scanner;

public class ItsAlwaysPrimeTime {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Enter an integer: ");
      int n = input.nextInt();
      int c = 0;
      for (int j = 1; j <= n; j++)
        if (n % j == 0)
          c++;
      if (c == 2 && n < 50 && n > 0) {
        System.out.print("Entered a prime number that is less than 50. Ending Program. ");
        break;
      }
    }
  }
}
