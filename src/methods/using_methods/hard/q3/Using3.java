package methods.using_methods.hard.q3;

/*
Write a Java Program that asks users for their favourite number, and then write a method called evenOrOdd that takes
that integer as an input parameter and determines if the number is even or odd. If a number is even, the method should return
a string calling it even, and if the number is odd, the method should return a string calling it odd.
 */

import java.util.Scanner;
public class Using3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your favourite number:");
        int favNum = input.nextInt();
        System.out.println("Your favourite number is " + evenOrOdd(favNum));
    }

    public static String evenOrOdd(int a) {
        if (a % 2 == 0)
            return "even";
        else
            return "odd";
    }
}