package loops.for_loops.hard.q6;

/*
 * Write a program that will accept a number from the user and print out the factorial of that number. ( Hint: n factorial or n! = 
 * n x (n - 1) x (n - 2) x … x 2 x 1 ). If the user enters a number less than 0, print "Invalid Input!"
 * 
 * Sample output:
 *    Enter a number: 
 *    3
 *    3! = 6
 * 
 */

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = input.nextInt();
    if (n < 0) {
      System.out.println("Invalid Input!");
      return;
    }
    int n2 = 1;
    for (int i = n; i > 0; i--)
      n2 *= i;
    System.out.println(n + "! = " + n2);
  }
}
