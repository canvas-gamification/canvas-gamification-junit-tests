package conditionals.programs_with_decision_points.hard.q4Java;
/*
Write a program that checks if the 3-digit or 5-digit number entered by the user is a palindrome, i.e. it is the same
when read forwards or backwards, like 343, or 54645, etc. If the number is a palindrome, print "(insert number) is a palindrome!".
If not, print "(insert number) is NOT a palindrome!". Your program should also check to make sure the entered number is
either 3-digits or 5-digits long, and print "Invalid number length!" if not. Assume the user inputs a number. Make sure your output
matches the example.
Sample Output:
    Enter an integer:
    12321
    12321 is a palindrome!
 */

import java.util.Scanner;

public class MyBestPal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = input.nextInt();
        if (num >= 100 && num <= 999) {
            if (num / 100 == num % 10)
                System.out.println(num + " is a palindrome!");
            else
                System.out.println(num + " is NOT a palindrome!");
        } else if (num >= 10000 && num <= 99999) {
            if ((num / 10000 == num % 10) && ((num / 1000) % 10 == (num % 100) / 10))
                System.out.println(num + " is a palindrome!");
            else
                System.out.println(num + " is NOT a palindrome!");
        } else
            System.out.println("Invalid number length!");
    }
}
