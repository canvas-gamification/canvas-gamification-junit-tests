package conditionals.programs_with_decision_points.hard.q11;
/*
Write a Java program that helps a store cashier determine if a purchase qualifies for the birthday discount. To promote
customer loyalty, the store gives all its customers a 10% discount for all purchases within 45 days of their birthday.
Ask the user for the day, month, and year of their most recent birthday as integers and calculates if today is within
45 days from that day. The program should display whether the purchase qualifies for a 10% discount. Assume the current
date is 27/09 and all months have 30 days. If the person qualifies for the discount print out "You qualify for a 10%
discount!", and if not, print "You do not qualify for any discounts.".
    Sample Output:
	Enter your birth day:
    12
    Enter your birth month as a number:
    11
    Enter the year of your most recent birthday:
    2022
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
        System.out.println("Enter the year of your most recent birthday: ");
        int birthYear = input.nextInt();
        int currentDay = 27;
        int currentMonth = 9;
        int currentYear = 2022;
        int difference = Math.abs(((birthYear - currentYear) * 365) + ((birthMonth - currentMonth) * 30) + birthDay - currentDay);
        if (difference <= 45)
            System.out.println("You qualify for a 10% discount!");
        else
            System.out.println("You do not qualify for any discounts.");
    }
}
