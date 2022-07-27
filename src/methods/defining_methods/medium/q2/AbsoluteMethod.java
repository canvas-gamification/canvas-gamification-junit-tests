package methods.defining_methods.medium.q2;
/*
Write a Java Program that calculates the absolute value of an already declared and initialized variable. Write a method
that accepts that input value and returns the absolute value.
Sample Output:
    The absolute value of the declared variable is: 5.0
 */

public class AbsoluteMethod {
    public static void main(String[] args) {
        double a = -200.56;
        System.out.println("The absolute value of the declared variable is: " + absCalc(a));
    }

    public static double absCalc(double a) {
        return Math.abs(a);
    }
}
