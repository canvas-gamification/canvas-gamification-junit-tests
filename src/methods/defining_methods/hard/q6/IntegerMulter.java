package methods.defining_methods.hard.q6;

/**
 * *[J] Write a Java Program that asks users for an integer between 0 and 10, then write a method
 * that takes an integer as an input parameter and returns that integer multiplied by 1000. Call
 * the method multiply1000. It’s guarantee that the input is in the range between 0 and 10.
 * 
 * Sample Output:
 * Enter a number:
 *    5
 *    The new number is: 5000
 * 
 */

import java.util.Scanner;

public class IntegerMulter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number:");
    int in = input.nextInt();
    System.out.println("The new number is: " + multiply1000(in));
  }

  public static int multiply1000(int a) {
    return a * 1000;
  }
}
