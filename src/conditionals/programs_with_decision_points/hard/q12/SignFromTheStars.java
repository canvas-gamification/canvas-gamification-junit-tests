package conditionals.programs_with_decision_points.hard.q12;

/*
Create a Java program which prompts the user to enter their birthday (day and month), and prints out what their
Astrological sign is. The entered birthday should be of the form DD/MM, so December 5 would be entered as "05/12". Use
the table below for the dates for each sign. Note that the date ranges are inclusive. If the user enters an invalid
birthdate, print "Invalid Date". Assume the user inputs data in the specified format.
Hint: To extract the day and month, try using String splitting and Integer.parseInt

Sample Output:
        Enter you birthdate (DD/MM):
        03/05
        Taurus

Astrological Signs
    Sign            	Dates
    Aries           	March 21 - April 19
    Taurus         		April 20 - May 20
    Gemini          	May 21 - June 21
    Cancer          	June 22 - July 22
    Leo             	July 23 - August 22
    Virgo           	August 23 - September 22
    Libra           	September 23 - October 22
    Scorpio         	October 23 - November 22
    Sagittarius     	November 23 - December 21
    Capricorn       	December 22 - January 19
    Aquarius        	January 20 - February 18
    Pisces          	February 19 - March 20

 */

import java.util.Scanner;

public class SignFromTheStars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you birthdate (DD/MM): ");
        String birthdate = input.next();
        int day = Integer.parseInt(birthdate.split("/")[0]);
        int month = Integer.parseInt(birthdate.split("/")[1]);
        String output = "Invalid date";
        if (day > 0) {
            if (month == 1) {
                if (day < 20)
                    output = "Capricorn";
                else if (day < 32)
                    output = "Aquarius";
            } else if (month == 2) {
                if (day < 19)
                    output = "Aquarius";
                else if (day < 30)
                    output = "Pisces";
            } else if (month == 3) {
                if (day < 21)
                    output = "Pisces";
                else if (day < 32)
                    output = "Aries";
            } else if (month == 4) {
                if (day < 20)
                    output = "Aries";
                else if (day < 31)
                    output = "Taurus";
            } else if (month == 5) {
                if (day < 21)
                    output = "Taurus";
                else if (day < 32)
                    output = "Gemini";
            } else if (month == 6) {
                if (day < 22)
                    output = "Gemini";
                else if (day < 31)
                    output = "Cancer";
            } else if (month == 7) {
                if (day < 23)
                    output = "Cancer";
                else if (day < 32)
                    output = "Leo";
            } else if (month == 8) {
                if (day < 23)
                    output = "Leo";
                else if (day < 32)
                    output = "Virgo";
            } else if (month == 9) {
                if (day < 23)
                    output = "Virgo";
                else if (day < 31)
                    output = "Libra";
            } else if (month == 10) {
                if (day < 23)
                    output = "Libra";
                else if (day < 32)
                    output = "Scorpio";
            } else if (month == 11) {
                if (day < 23)
                    output = "Scorpio";
                else if (day < 31)
                    output = "Sagittarius";
            } else if (month == 12) {
                if (day < 22)
                    output = "Sagittarius";
                else if (day < 32)
                    output = "Capricorn";
            }
        }
        System.out.println(output);
    }
}
