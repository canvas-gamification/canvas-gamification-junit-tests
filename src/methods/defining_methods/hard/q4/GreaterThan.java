package methods.defining_methods.hard.q4;

/*
Write a Java Program that asks the user for two integers, then prints out the greater of the two integers. Write a method
called greaterNum that accepts two integers as parameters and returns the greater of the two to be printed in the main method.

Sample Output:
  Enter the first number: 5
  Enter the second number: 10
  The greater number is 10
 */

import java.util.Scanner;

public class GreaterThan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int first = input.nextInt();
        System.out.print("Enter the second number: ");
        int second = input.nextInt();
        System.out.println("The greater number is " + greaterNum(first, second));
    }

    public static int greaterNum(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
}
