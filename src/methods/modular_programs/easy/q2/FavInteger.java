package methods.modular_programs.easy.q2;
/*
Write a Java Program that asks users for their favourite integer. Then, take that number and do two things with that
number. First, determine if the number is even or odd. Do this by writing a method called isEven that returns a boolean
value (true if it is even, and false if it is not). Second, create a method called multiply which multiplies the number
by 𝛑, and return that value. The main method should print if the number is even or odd, and what the number multiplied
by 𝛑 is.

Sample Output:
    Please enter your favourite integer:
    39
    Your favourite number is odd.
    Your number multiplied by PI is: 122.52211349000193
 */

import java.util.Scanner;

public class FavInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your favourite integer: ");
        int fav = input.nextInt();
        if (isEven(fav))
            System.out.println("Your favourite integer is even. ");
        else
            System.out.println("Your favourite integer is odd. ");
        System.out.println("Your number multiplied by PI is: " + multiply(fav));
    }

    public static boolean isEven(int a) {
        if (a % 2 == 0)
            return true;
        else
            return false;
    }

    public static double multiply(int a) {
        return Math.PI * a;
    }
}
