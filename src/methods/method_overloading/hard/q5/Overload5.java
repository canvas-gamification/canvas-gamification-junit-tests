package methods.method_overloading.hard.q5;

/**
 * [J] Write a Java Program to calculate the average of 3 to 5 integers
 * depending on the user input. Use method overloading in your solution. Display
 * the result of the following 3 sets:
 *  #1: 2, 1, 4
 *  #2: 6, 31, 3, 51
 *  #3: -2, -2, -1, -2, -1
 * 
 *  Sample Output:
 *    The average of the following numbers is: 2
 *    The average of the following numbers is: 22
 *    The average of the following numbers is: 202
 */
public class Overload5 {
  public static void main(String[] args) {
    System.out.println("The average of the following numbers is: " + average(2, 1, 4));
    System.out.println("The average of the following numbers is: " + average(6, 31, 3, 51));
    System.out.println("The average of the following numbers is: " + average(2, 1, 4, 5, 999));
  }

  public static int average(int num1, int num2, int num3) {
    return (num1 + num2 + num3) / 3;
  }

  public static int average(int num1, int num2, int num3, int num4) {
    return (num1 + num2 + num3 + num4) / 4;
  }

  public static int average(int num1, int num2, int num3, int num4, int num5) {
    return (num1 + num2 + num3 + num4 + num5) / 5;
  }
}
