package methods.method_overloading.hard.q2;

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
