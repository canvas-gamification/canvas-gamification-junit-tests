package methods.modular_programs.hard.q10;

/*
 Create a Java program which prompts the user to enter a year, and then prints out what Chinese Zodiac sign that year
 is. For simplicity, assume that the sign runs for a standard calendar year (January to December). There are twelve
 different signs: Rat, Ox, Tiger, Rabbit, Dragon, Snake, Horse, Goat, Monkey, Rooster, Dog, and Pig, in that order, with
 it looping around from Pig to Rat to restart the cycle. Note that if it is the year of the Monkey, the year will be
 divisible by 12. For example, 1992 was the year of the Monkey, and 1992 % 12 = 0. To determine the year, use a method
 called zodiacSign, which receives the year as an integer and returns a string of the zodiac animal. Assume the user
 will enter a valid year, and that the year is in the common era (greater than 0).

 Sample output:
     Enter a year:
     2013
     The Chinese zodiac sign for the year 2013 is Snake.
 */

import java.util.Scanner;

public class GoatYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = input.nextInt();
        String sign = zodiacSign(year);
        System.out.printf("The Chinese zodiac sign for the year %d is %s.\n", year, sign);
    }

    public static String zodiacSign(int year) {
        String sign = "";
        if (year % 12 == 0) {
            sign = "Monkey";
        } else if (year % 12 == 1) {
            sign = "Rooster";
        } else if (year % 12 == 2) {
            sign = "Dog";
        } else if (year % 12 == 3) {
            sign = "Pig";
        } else if (year % 12 == 4) {
            sign = "Rat";
        } else if (year % 12 == 5) {
            sign = "Ox";
        } else if (year % 12 == 6) {
            sign = "Tiger";
        } else if (year % 12 == 7) {
            sign = "Rabbit";
        } else if (year % 12 == 8) {
            sign = "Dragon";
        } else if (year % 12 == 9) {
            sign = "Snake";
        } else if (year % 12 == 10) {
            sign = "Horse";
        } else if (year % 12 == 11) {
            sign = "Goat";
        }
        return sign;
    }
}
