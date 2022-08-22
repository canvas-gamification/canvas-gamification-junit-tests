package methods.modular_programs.easy.q6;

/*
Write a Java Program that asks users for the year they were born, then returns what century that year is in. The program
should have a method called centuryCalc to determine this, which works for any century from the 1500's to 2000's. If the
input is in any other century, return "Unknown Century".
Sample output:
Please enter the year you were born in:
2002
You're from the 21st Century
 */

import java.util.Scanner;

public class Century {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the year you were born in: ");
        int userYear = input.nextInt();
        System.out.println("You're from the " + centuryCalc(userYear));
    }

    public static String centuryCalc(int userYear) {
        if (userYear >= 2000)
            return "21st Century";
        else if (userYear > 1899)
            return "20th Century";
        else if (userYear > 1799)
            return "19th Century";
        else if (userYear > 1699)
            return "18th Century";
        else if (userYear > 1599)
            return "17th Century";
        else if (userYear > 1499)
            return "16th Century";
        else
            return "Unknown Century";
    }
}

