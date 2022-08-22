package methods.method_overloading.medium.q6;

/**
 * Overload a Java Method so that it can take a double variable and float
 * variable or it can take a int variable and long variable, then divide the
 * former variable by the latter variable.
 */
public class OverloadFloat {
  public static double divide(double a, float b) {
    return a / b;
  }

  public static double divide(int a, long b) {
    return a / b;
  }
}
