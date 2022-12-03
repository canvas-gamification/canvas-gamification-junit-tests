package methods.modular_programs.medium.q9;

/*
Write a program that asks for two integers and passes them to a method called maxOut which check is one of the numbers
is divisible by the other. If so, it returns a string of the format "x is the max". If not, it should return “Not
divisible”. The main method then prints the returned string.

Sample Output:
  Enter the first number:
  10
  Enter the second number:
  5
  10 is the max
 */

import java.util.Scanner;

public class MaxItOut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int n1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int n2 = input.nextInt();
        System.out.println(maxOut(n1, n2));
    }

    public static String maxOut(int n1, int n2) {
        String res;
        if (n1 % n2 == 0) {
            if (n1 < n2)
                res = n2 + " is the max";
            else
                res = n1 + " is the max";
        } else if (n2 % n1 == 0) {
            if (n1 < n2)
                res = n2 + " is the max";
            else
                res = n1 + " is the max";
        } else {
            res = "Not divisible";
        }

        return res;
    }
}
