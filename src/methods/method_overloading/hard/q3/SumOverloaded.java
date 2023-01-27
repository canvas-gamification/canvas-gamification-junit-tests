package methods.method_overloading.hard.q3;

/*
Write a Java program that prompts the user to input two integers and two doubles. Then pass each pair of numbers to an
overloaded method called sum which takes the two numbers as parameters and returns their sum. Print the returned sums
in the main method.

Sample Output:
  Enter two integers:
  43 56
  Enter two doubles:
  91.4 26.1
  The sum of the 2 integers is: 99
  The sum of the 2 doubles is: 117.5
*/

import java.util.Scanner;

public class SumOverloaded {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter two integers: ");
    int one = input.nextInt();
    int two = input.nextInt();
    System.out.println("Enter two doubles: ");
    double x = input.nextDouble();
    double y = input.nextDouble();
    System.out.println("The sum of the 2 integers is: " + sum(one, two));
    System.out.println("The sum of the 2 doubles is: " + sum(x, y));
  }

  public static int sum(int num1, int num2) {
    return num1 + num2;
  }

  public static double sum(double num1, double num2) {
    return num1 + num2;
  }
}
