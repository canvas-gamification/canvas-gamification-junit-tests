package methods.method_overloading.hard.q3;

/**
 * [J] Write a Java Program that can handle the addition of the 2 following
 * number sets, then overload a method so that it can accept either a number
 * with or without decimals and return the sum of the 2 numbers. Let's call that
 * method "sum".
 * Number set #1: 43, 56
 * Number set #2: 91.4, 26.1
 * 
 * Sample Output:
 * The sum of the 2 numbers: 99
 * The sum of the 2 numbers: 117.5
 */

public class Overload3 {
  public static void main(String[] args) {
    System.out.println("The sum of the 2 numbers: " + sum(43, 56));
    System.out.println("The sum of the 2 numbers: " + sum(91.4, 26.1));
  }

  public static int sum(int num1, int num2) {
    return num1 + num2;
  }

  public static double sum(double num1, double num2) {
    return num1 + num2;
  }
}
