package loops.programs_with_repetition.medium.q5;

/*
 * Write a program to print an arrow using the char “*” with nested loops and a positive integer n representing the width of the arrow.
 * If the user enters a negative integer or 0, the program should print an error message.
 * 
 *    Sample output: 
 *    How wide is your arrow?
 *    5
 *    *
 *    * * 
 *    * * * 
 *    * * * * 
 *    * * * * *
 *    * * * *
 *    * * *
 *    * *
 *    *
 * 
 */

import java.util.Scanner;

public class ThatWay {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.println("How wide is your arrow?");
    int n = inp.nextInt();
    if (n <= 0) {
      System.out.println("Invalid Input!");
      return;
    }
    for (int i = 0; i < n; i++) {
      for (int k = 0; k <= i; k++)
        System.out.print("* ");
      System.out.println();
    }
    for (int i = 1; i < n; i++) {
      for (int k = 0; k < n - i; k++)
        System.out.print("* ");
      System.out.println();
    }
  }
}
