package methods.method_overloading.hard.q2;

/*
Write a Java Program that asks the user for a string. Then overload a method named “stringLength” so that
it can accept either a string, or a string and an integer, and then returns the length of a string added with the integer
(if no integer is given, then just return the length of the string). The main method should use these methods to print
the length of the string, and the length of the string plus 7. Ensure that your output matches the sample.
Sample Output:
	Please enter a sentence:
    Hello, how are you doing?
    The length of the string is: 25
    The length of the string plus the integer is: 32
 */

import java.util.Scanner;

public class Overload101 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a sentence:");
        String in = input.nextLine();
        System.out.println("The length of the string is: " + stringLength(in));
        System.out.println("The length of the string plus the integer is: " + stringLength(in, 7));
    }

    public static int stringLength(String a) {
        return a.length();
    }

    public static int stringLength(String a, int b) {
        return a.length() + b;
    }
}
