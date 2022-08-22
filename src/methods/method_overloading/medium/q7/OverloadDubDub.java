package methods.method_overloading.medium.q7;

/**
 * Overload a Java Method so that it can take either a double variable, or a
 * double variable and an integer variable. In the method with only one input
 * parameter, multiply the input value by 1000, then return it. In the method
 * with two input parameters, multiply both values together and return that
 * value.
 */
public class OverloadDubDub {
  public static double multiply(double a) {
    return a * 1000;
  }

  public static double multiply(double a, int b) {
    return a * b;
  }
}
