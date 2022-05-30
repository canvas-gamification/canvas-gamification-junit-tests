package conditionals.programs_with_decision_points.hard.q4;
/*
Write a program that checks if the 3-digit or 5-digit number entered by the user is a palindrome, i.e. is the same when
read forwards or backwards, like 343, or 54645, etc. Make sure to display an error message if the number entered is not
either 3-digits or 5-digits long. Assume the user inputs a number.

Sample Output:
Enter an integer:
12321
12321 is a palindrome!

Distractors:
    if( num >= 100 && num <= 999 )
    else ( num >= 10000 && num <= 99999 )
    else if( num >= 10000 || num <= 99999 )
    if( ( num * 10000 == num % 10 ) && ( ( num * 1000 ) % 10 == ( num % 100 ) / 10 ) )
    if( num / 100 = num % 10 )
    if( num > 100 && num < 999 )

 */
import java.util.Scanner;

public class MyBestPal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
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
