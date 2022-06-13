package methods.defining_methods.medium.q1;
/*
Write a Java Program that calculates the value of an integer raised to the power of another integer. The variables
should already be declared and initialized in the main method. Write a method that accepts both integer values as input
parameters and returns a double of the first integer raised to the power of the second.
Sample Output:
    The value of the first integer raised to the power of the second integer is: 9765625.0
 */
public class RaiseToPower {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("The value of the first integer raised to the power of the second integer is: " + powerCalc(a, b));
    }

    public static double powerCalc(int a, int b) {
        return Math.pow(a, b);
    }
}
