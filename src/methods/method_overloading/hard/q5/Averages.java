package methods.method_overloading.hard.q5;

/*
Write a Java program to calculate the average of sets of 3, 4, and 5 numbers. To do this, create a method called average
and overload it to accept 3, 4, and 5 integers, and then returns the average of the set of numbers as a double. Your
program should prompt the user to enter a set of 3, 4, and 5 numbers, calculate the average for each set and print out
the average in the main method.

Sample Output:
  Enter three numbers:
  2 1 4
  Enter four numbers:
  6 31 3 51
  Enter five numbers:
  2 1 4 5 999
  The average of the three numbers is: 2.3333333333333335
  The average of the four numbers is: 22.75
  The average of the five numbers is: 202.2
 */

import java.util.Scanner;

public class Averages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        System.out.println("Enter four numbers: ");
        int n4 = input.nextInt();
        int n5 = input.nextInt();
        int n6 = input.nextInt();
        int n7 = input.nextInt();
        System.out.println("Enter five numbers: ");
        int n8 = input.nextInt();
        int n9 = input.nextInt();
        int n10 = input.nextInt();
        int n11 = input.nextInt();
        int n12 = input.nextInt();
        System.out.println("The average of the three numbers is: " + average(n1, n2, n3));
        System.out.println("The average of the four numbers is: " + average(n4, n5, n6, n7));
        System.out.println("The average of the five numbers is: " + average(n8, n9, n10, n11, n12));
    }

    public static double average(int num1, int num2, int num3) {
        return (num1 + num2 + num3) / 3.0;
    }

    public static double average(int num1, int num2, int num3, int num4) {
        return (num1 + num2 + num3 + num4) / 4.0;
    }

    public static double average(int num1, int num2, int num3, int num4, int num5) {
        return (num1 + num2 + num3 + num4 + num5) / 5.0;
    }
}
