package conditionals.programs_with_decision_points.hard.q11;
/*
Write a Java program that helps a store cashier determine if a purchase qualifies for the birthday discount. To promote
customer loyalty, the store gives all its customers a 10% discount for all purchases within 45 days of their birthday.
Ask the user for the day and month of their birthday as integers and calculates if today is within
45 days from that day. The program should display whether the purchase qualifies for a 10% discount. Assume the current
date is 27/09 and all months have 30 days. If the person qualifies for the discount print out "You qualify for a 10%
discount!", and if not, print "You do not qualify for any discounts.".

Sample Output:
	Enter your birthday:
    12
    Enter your birth month as a number:
    11
    You qualify for a 10% discount!

 */

import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birth day: ");
        int birthDay = input.nextInt();
        System.out.println("Enter your birth month as a number: ");
        int birthMonth = input.nextInt();
        int currentDay = 27;
        int currentMonth = 9;
        int daysBirth = birthDay + (birthMonth - 1) * 30;
        int daysCurrent = currentDay + (currentMonth - 1) * 30;
        if (((daysBirth - 45) <= daysCurrent && (daysBirth + 45) >= daysCurrent) ||
                ((daysBirth - 45) <= daysCurrent - 360 && (daysBirth + 45) >= daysCurrent - 360) ||
                ((daysBirth - 45) <= daysCurrent + 360 && (daysBirth + 45) >= daysCurrent + 360))
            System.out.println("You qualify for a 10% discount!");
        else
            System.out.println("You do not qualify for any discounts.");
    }
}
