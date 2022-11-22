package methods.method_overloading.hard.q8;

/*
Write a Java Program that asks the user for an integer and a double and then prints out a message with the data type of
each number. To identify the data type, write two methods called printType, one that accepts an int and returns the
string "int" and one that takes a double and returns the string "double".

Sample Output:
    Enter an integer:
    5
    Enter a double:
    16.32
    The data type associated with 5 is: int
    The data type associated with 16.32 is: double
 */

import java.util.Scanner;

public class FindDataType {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int x = input.nextInt();
        System.out.println("Enter a double: ");
        double y = input.nextDouble();
        System.out.println("The data type associated with " + x + " is: " + printType(x));
        System.out.println("The data type associated with " + y + " is: " + printType(y));
    }

    public static String printType(int x) {
        return "int";
    }

    public static String printType(double x) {
        return "double";
    }

}
