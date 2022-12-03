package methods.method_overloading.hard.q7;

/*
Write a Java Program that calculates the distance between 2 points given by the user. The first set of points are
doubles and the second set integers. Pass each set of values to an overloaded method called calcDistance, one method
for doubles and one for integers. The calculation should be done by subtracting the two points and returning the
absolute value of the answer.

Sample Output:
    Enter a set of doubles:
    141.4 591.3
    Enter a set of integers:
    46 985
    The distance between the set of doubles is: 449.9
    The distance between the set of integers is: 939
 */

import java.util.Scanner;

public class Distances {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a set of doubles: ");
        double x = input.nextDouble();
        double y = input.nextDouble();
        System.out.println("Enter a set of integers: ");
        int a = input.nextInt();
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
