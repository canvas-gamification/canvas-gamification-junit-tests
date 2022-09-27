package test;

import java.util.Random;

public class MethodClause {
    public static void main(String[] args) {
        int z = add(3, 7);
        print("The sum of two numbers is: " + z);
        areaCalc(4, 5);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static double areaCalc(double x, double y) {
        /*
            This method is an example of where the return value and the console output are different. With how methodTest
            handles testing, these values can be tested independently of each other, so that the incorrect printed value
            does not fail the test on the return value.
         */
        double area = x * y;
        System.out.println("The area is 38.96");
        return area;
    }

    public static int testMethod() {
        /*
            If you look at the corresponding test, this method demonstrates how MethodTest can independently test the
            returned value and printed output.
         */
        System.out.println(35);
        System.out.println("Hello world");
        System.out.println(34.124);
        return 70;
    }
}
