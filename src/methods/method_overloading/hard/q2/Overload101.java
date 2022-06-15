package methods.method_overloading.hard.q2;

/*
Write a Java Program that asks the user for a string and an integer. Then overload a method named “stringLength” so that
it can accept either a string, or a string and an integer, and then returns the length of a string added with the integer
(if no integer is given, then just return the length of the string). The main method should print both the length of the
string alone, and the length of the string plus the input integer. Ensure that your output matches the sample.
Sample Output:
	Please enter a sentence:
    Hello, how are you doing?
    Please enter an integer:
    39
    The length of the string is: 25
    The length of the string plus the integer is: 64
 */

import java.util.Scanner;

public class Overload101 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a sentence:");
        String in = input.nextLine();
        System.out.println("Please enter an integer:");
        int n = input.nextInt();
        System.out.println("The length of the string is: " + stringLength(in));
        System.out.println("The length of the string plus the integer is: " + stringLength(in, n));
    }

    public static int stringLength(String a) {
        return a.length();
    }

    public static int stringLength(String a, int b) {
        return a.length() + b;
    }
}
