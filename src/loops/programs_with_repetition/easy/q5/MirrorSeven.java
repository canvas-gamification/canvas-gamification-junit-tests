package loops.programs_with_repetition.easy.q5;

/*
 * Write a program to keep asking the user to enter a number until they enter a palindrome number that is also
 * divisible by 7 (i.e. it can be read the same forwards and backwards). Once it receives a valid integer, the program should print the message 
 * "Entered a palindrome that is divisible by 7. Ending Program.".
 * Sample output:
 *    Enter an integer: 
 *    123
 *    Enter an integer:
 *    123321
 *    Enter an integer:
 *    787
 *    Enter an integer:
 *    777
 *    Entered a palindrome that is divisible by 7. Ending Program.
 */

import java.util.Scanner;

import global.tools.Logger;

public class MirrorSeven {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Enter an integer: ");
      int n = input.nextInt();
      Logger.logMessage(n + " ");
      int reverse = 0;
      int original = n;
      while (n > 0) {
        reverse = (reverse * 10) + (n % 10);
        n = n / 10;
      }
      if (reverse == original && original % 7 == 0) {
        System.out.print("Entered a palindrome that is divisible by 7. Ending Program.");
        break;
      }
    }
  }
}
