package methods.method_overloading.hard.q7;

/*
Write a Java Program that calculates the distance between 2 sets of points where one point is already specified and the
other is given by the user. The first set of points are 7.32 and a double given by the user and the second set is 3 and
an integer given by the user. Pass each set of values to  an overloaded method called calcDistance, one method takes two
doubles and the other two integers. The calculation should be done by subtracting the two points and returning the
absolute value of the answer.

Sample Output:
    Enter a double:
    141.4
    Enter an integer:
    46
    The distance between the set of doubles is: 133.78
    The distance between the set of integers is: 43
 */

import java.util.Scanner;

public class Distances {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a double: ");
        double x = 7.32;
        double y = input.nextDouble();
        System.out.println("Enter an integer: ");
        int a = 3;
        int b = input.nextInt();
        System.out.println("The distance between the set of doubles is: " + calcDistance(x, y));
        System.out.println("The distance between the set of integers is: " + calcDistance(a, b));
    }

    public static int calcDistance(int x, int y) {
        return Math.abs(x - y);
    }

    public static double calcDistance(double x, double y) {
        return Math.abs(x - y);
    }

}
