package methods.method_overloading.medium.q4;

/*
 Overload a Java Method called average so that it can take three integer variables or three double variables and returns the average
 of the values as doubles.
 */
public class AveOfThree {
    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static double average(double a, double b, double c) {
        return (a + b + c) / 3;
    }
}
