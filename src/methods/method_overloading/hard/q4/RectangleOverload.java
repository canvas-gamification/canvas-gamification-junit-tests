package methods.method_overloading.hard.q4;

/*
Write a Java Program that prompts the user to enter two integers and two doubles which will be used to calculate
rectangle areas. This calculation will be performed by four overloaded methods called rectangleArea. The first takes
both integer values for the sides of the rectangle and returns and integer. The second takes the first integer and the
first double for the sides of the rectangle and returns a double. The third takes the second integer and uses it for all
sides of the rectangle and returns an integers. The fourth takes the second double and uses it for all sides of the
rectangle and returns a double. Assume the user will only enter positive numbers.

Sample Output:
  Enter two integers:
  2 4
  Enter two doubles:
  5.3 3.3
  The area of the first rectangle is: 8
  The area of the second rectangle is: 10.6
  The area of the third rectangle is: 16
  The area of the fourth rectangle is: 10.889999999999999
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
        System.out.println("The area of the first rectangle is: " + rectangleArea(a, b));
        System.out.println("The area of the second rectangle is: " + rectangleArea(a, x));
        System.out.println("The area of the third rectangle is: " + rectangleArea(b));
        System.out.println("The area of the fourth rectangle is: " + rectangleArea(y));
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
