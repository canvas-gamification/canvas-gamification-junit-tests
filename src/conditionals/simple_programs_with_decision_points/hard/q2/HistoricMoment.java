package conditionals.simple_programs_with_decision_points.hard.q2;
/*
Write a program that asks for a year, and whether it is AD or BC, and subtracts one year from the given year and
displays the results. ( Hint: 10 AD - 1 year = 9 AD, and 1 BC - 1 year = 2BC ). For simplicity, assume the user will not
enter 0 AD, and that the user enters a number.

Sample Output:
    Enter a year:
    2020
    Is it AD or BC? (Enter true for AD and false for BC)
    true
    2020 AD - 1 = 2019 AD

Distractors:
    if( ad = true )
    if( ad == T)
    if( ad );
    if( AD )
    else (ad == false)
    else( ad == false);
    if( ad == true );

 */
import java.util.Scanner;

public class HistoricMoment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year:");
        int year = input.nextInt();
        System.out.println("Is it AD or BC? (Enter true for AD and false for BC)");
        boolean ad = input.nextBoolean();
        if (ad)
            System.out.println(year + " AD - 1 = " + (year - 1) + " AD");
        else
            System.out.println(year + " BC - 1 = " + (year + 1) + " BC");
    }
}
