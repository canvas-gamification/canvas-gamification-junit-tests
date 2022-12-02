package methods.method_overloading.medium.q6;

/*
Overload a Java method called divide which divides the first passed parameter by the second. The first method
should take a double and float and return a double. The second method should take an int and a long and return a double.
 */
public class OverloadFloat {
    public static double divide(double a, float b) {
        return a / b;
    }

    public static double divide(int a, long b) { return a / b; }
}
