package test.methods;

import java.util.Scanner;

public class MethodClause {
    public static void main(String[] args) {
        System.out.println("This is the main method.");
        int x = 5;
        int y = return15();
        int sum = sum(x, y);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a double: ");
        double d = input.nextDouble();
        double area = area(d, sum);
        printMessage("The area of the rectangle is: " + area);
    }

    public static int sum(int x, int y){
        /*
            This method calculates the sum of two integers, and prints out both those integers and what the sum is.
            Using method test, the value which is returned and the value which is printed in the output can be tested
            independently of each other and of the main method.
         */
        int sum = x + y;
        System.out.printf("The sum of %d and %d is %d\n", x, y, sum);
        return sum;
    }

    public static double area(double x, double y){
        /*
            This method prints a message and calculates the area of a rectangle. The message and output can be tested
            independently using MethodTest.
         */
        System.out.println("Calculating the area of a rectangle: ");
        return x * y;
    }

    public static void printMessage(String message){
        // This method prints whatever is passed in the String message parameter, and can be tested using MethodTest
        System.out.println(message);
    }

    public static int return15(){
        // This method returns the number 15
        return 15;
    }
}
