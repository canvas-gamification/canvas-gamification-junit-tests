package methods.method_overloading.hard.q4;

/**
 * [J] Write a Java Program with overloading method named rectangleArea that can
 * calculates and returns the area of a rectangle given the user enters any of
 * the following information:
 *    - 2 integer values for each side of the rectangle i.e 2, 4
 *    - 2 values for each side of the rectangle, one integer and another decimal
 * i.e 2, 5.3
 *    - 1 integer values for all sides of the rectangle i.e 10
 *    -1 decimal number for all sides of the rectangle i.e 3.3
 * 
 * 
 * Sample Output:
 *    The area of the rectangle is: 8
 *    The area of the rectangle is: 10.6
 *    The area of the rectangle is: 100
 *    The area of the rectangle is: 10.89
 */

public class Overload4 {
  public static void main(String[] args) {
    System.out.println("The area of the rectangle is: " + rectangleArea(2, 4));
    System.out.println("The area of the rectangle is: " + rectangleArea(2, 5.3));
    System.out.println("The area of the rectangle is: " + rectangleArea(10));
    System.out.println("The area of the rectangle is: " + rectangleArea(3.3));
  }

  public static int rectangleArea(int num1, int num2) {
    return num1 * num2;
  }

  public static int rectangleArea(int num) {
    return num * num;
  }

  public static double rectangleArea(int num1, double num2) {
    return num1 * num2;
  }

  public static double rectangleArea(double num) {
    return num * num;
  }

}
