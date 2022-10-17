package conditionals.programs_with_decision_points.hard.q11;
/*
Write a Java question that helps a store cashier determine if a given purchase qualifies for the birthday discount.
To promote customer loyalty, the store gives all its customers a 10% discount for every purchase within 45 days of their
birthday. In this program, ask the user for the birthday (day and month only) as integers and calculates if today is 45
days from that birthday or not. The program should display whether the purchase qualifies for a 10% discount or not.
 Assume the current date is 27/09 and all months have 30 days in them. If the person qualifies for the discount, print
"You qualify for a 10% discount!", and if not print "You do not qualify for any discounts.".
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
        int currentMonth = 9;
        int currentDay = 27;
        int monthDiff = currentMonth - birthMonth;
        int dayDiff = currentDay - birthDay;
        if (Math.abs(monthDiff * 30 + dayDiff) <= 45)
            System.out.println("You qualify for a 10% discount!");
        else
            System.out.println("You do not qualify for any discounts.");
    }
}
