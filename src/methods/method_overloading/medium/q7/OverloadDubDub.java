package methods.method_overloading.medium.q7;

/*
Overload a Java Method so that it can take either a double variable, or a double variable and an integer variable. The
method that only takes a double should multiply the input value by 1000, then return it. In the method with two inputs,
return the multiplication of both values.
 */
public class OverloadDubDub {
    public static double multiply(double a) {
        return a * 1000;
    }

    public static double multiply(double a, int b) {
        return a * b;
    }
}
