package methods.method_overloading.medium.q5;

/*
Overload a Java method called multiply so that it can take two integer variables or one integer variable and one double
variable and multiply both values together, returning an integer and double respectively.
 */
public class OverloadIt {
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, int b) {
        return a * b;
    }
}
