package methods.defining_methods.medium.q2;
/*
Write a Java Program that calculates the absolute value of an already declared and initialized variable. The program
should have a method called absCalc that accepts a double and returns the absolute value of that number. Use this
method to compute the absolute value and print the answer in the main method.

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
