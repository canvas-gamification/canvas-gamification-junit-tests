package conditionals.programs_with_decision_points.hard.q3;
/*
Write a program that will verify if an entered date is valid. A valid date has anywhere within 1 - 31 days, 1 - 12 months,
and a year that is later than 1000 but less than 10,000. For simplicity's sake, you don't have to verify that a certain
month has only a certain number of days. Make sure to print an error message in case the date entered is invalid.
Assume the user enters integers.

Sample Output:
    Enter Day (DD):
    30
    Enter Month (MM):
    5
    Enter Year (YYYY):
    2022
    Valid Date!

Distractors:
    System.out.println("Enter Year ( YY ):  ")
    if( year >= 1000 || year <= 9999 )
    if( month >= 1 || month <= 12 )
    if( day >= 1 || day <= 31 )
    if( day >= 1 && day <= 30 )
    if( year >= 0 && year <= 9999 )

 */
import java.util.Scanner;

public class SaveTheDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Day (DD):");
        int day = input.nextInt();
        System.out.println("Enter Month (MM):");
        int month = input.nextInt();
        System.out.println("Enter Year (YYYY):");
        int year = input.nextInt();
        if (year >= 1000 && year <= 9999) {
            if (month >= 1 && month <= 12) {
                if (day >= 1 && day <= 31)
                    System.out.println("Valid Date!");
                else
                    System.out.println("Invalid Day!");
            } else
                System.out.println("Invalid Month!");
        } else
            System.out.println("Invalid Year!");
    }
}
