package methods.defining_methods.hard.q8;

/**
 * [J] Write a Java Program that passes in a number and prints out a message
 * with the data type of the number that was passed in into the method. Use
 * method overloading to only call one method and let's call that method
 * printType.
 * 
 * Sample Output:
 *  The data type associated with 14 is : int
 *  The data type associated with 61.34 is : double
 */

public class Overload8 {
  public static void main(String[] args) {
    System.out.println("The data type associated with 14 is: " + printType(14));
    System.out.println("The data type associated with 61.34 is: " + printType(61.34));
  }

  public static String printType(int x) {
    return "int";
  }

  public static String printType(double x) {
    return "double";
  }

}
