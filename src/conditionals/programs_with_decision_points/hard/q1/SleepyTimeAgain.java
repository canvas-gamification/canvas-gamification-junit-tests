package conditionals.programs_with_decision_points.hard.q1;
/*
Write a program that asks the user for the current time, verifies that it is valid, and tells them to go to sleep if it
is later than 21:30. Make sure to display an error message if they enter an invalid time (Note: Valid Time is anywhere
between 0 - 23h and 0 - 59m). Assume the user enters integers.

Sample Output:
		Current Time Hours (in a 24h clock):
        20
        Current Time Minutes:
        30
        The night is still young!

Distractors
    System.out.println("Current Time Hours (in a 12h clock): ")
    int hours = input.next();
    int mins = input.nextDouble();
    if( hours >= 0 || hours <= 23 || mins >= 0 || mins <= 59 )
    if( hours >= 22 ||  mins >= 30 )
    else if( hours > 22)

 */

import java.util.Scanner;

public class SleepyTimeAgain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Current Time Hours (in a 24h clock): ");
        int hours = input.nextInt();
        System.out.println("Current Time Minutes: ");
        int mins = input.nextInt();
        if (hours >= 0 && hours <= 23 && mins >= 0 && mins <= 59) {
            if (hours > 21 || (hours == 21 && mins >= 30))
                System.out.println("Please go to sleep.");
            else
                System.out.println("The night is still young!");
        } else
            System.out.println("Invalid time!");
    }
}
