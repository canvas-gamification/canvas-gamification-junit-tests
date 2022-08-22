package methods.method_overloading.hard.q7;

/**
 * [J] Write a Java Program that calculates the distance between 2 points passed
 * in. The calculation should be done by subtracting the two points and
 * returning the absolute value of the answer. The coordinates could either be
 * integers or doubles. Use method overloading to only call one method to
 * calculate the distance.
 * 
 * Sample Output:
 *    The distance between 141.4 and 591.3 is: 449.9
 *    The distance between 46 and 985 is: 939
 */
public class Overload7 {
  public static void main(String[] args) {
    System.out.println("The distance between 141.4 and 591.3 is: " + calcDistance(141.4, 591.3));
    System.out.println("The distance between 46 and 985 is: " + calcDistance(46, 985));
  }

  public static int calcDistance(int x, int y) {
    return Math.abs(x - y);
  }

  public static double calcDistance(double x, double y) {
    return Math.abs(x - y);
  }

}
