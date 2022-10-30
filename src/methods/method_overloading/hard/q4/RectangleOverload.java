package methods.method_overloading.hard.q4;

/*
Write a Java Program that prompts the user to enter two integers and two doubles. Then write four overloaded methods
called rectangleArea. The first takes both integer values for each side of the rectangle. The second takes the first
integer and the first double for each side of the rectangle. The third takes the second integer and uses it for all
sides of the rectangle. The fourth takes the second double and uses it for all sides of the rectangle.

Sample Output:
  Enter two integers:
  2 4
  Enter two doubles:
  5.3 3.3
  The area of the rectangle is: 8
  The area of the rectangle is: 10.6
  The area of the rectangle is: 16
  The area of the rectangle is: 10.889999999999999
 */

import java.util.Scanner;

public class RectangleOverload {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("Enter two doubles: ");
        double x = input.nextDouble();
        double y = input.nextDouble();
        System.out.println("The area of the rectangle is: " + rectangleArea(a, b));
        System.out.println("The area of the rectangle is: " + rectangleArea(a, x));
        System.out.println("The area of the rectangle is: " + rectangleArea(b));
        System.out.println("The area of the rectangle is: " + rectangleArea(y));
    }

    public static int rectangleArea(int num1, int num2) {
        return num1 * num2;
    }

    public static int rectangleArea(int num) {
        return num * num;
    }

    public static double rectangleArea(int num1, double num2) {
        return num1 * num2;
    }

    public static double rectangleArea(double num) {
        return num * num;
    }

}
