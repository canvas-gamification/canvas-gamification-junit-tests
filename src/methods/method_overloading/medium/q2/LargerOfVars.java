package methods.method_overloading.medium.q2;
/*
Write a Java Program that takes two variables, an integer and a double (they are already declared and initialized) and
calculates the larger of the two variables. Write two methods named max to complete this. Each method should take in an
integer and a double, but their order should be opposite, and both should return the larger value. Then, print out the
returned larger value.
Sample Output:
    The greater value is: x
 */
public class LargerOfVars {
    public static void main(String[] args) {
        double a = 5.5;
        int b = 5;
        System.out.println("The greater value is: " + max(a, b));
    }

    public static double max(double a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static double max(int a, double b) {
        if (a > b)
            return a;
        else
            return b;
    }
}
